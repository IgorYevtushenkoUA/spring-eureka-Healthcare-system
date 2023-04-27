package com.example.eurekaclient2.controller;

import com.example.eurekaclient2.dto.AppointmentDTO;
import com.example.eurekaclient2.entity.MedicalRecord;
import com.example.eurekaclient2.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app/medical-record")
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping("/doctor/{id}/patients")
    public List<MedicalRecord> getPatientMedicalRecords(@PathVariable Integer id,
                                                        @RequestParam(required = false) String startDate,
                                                        @RequestParam(required = false) String endDate) throws ParseException {
        List<MedicalRecord> medicalRecords;
        if (startDate != null) {
            Date dateStart = parseStringToDate(startDate);
            Date dateEnd = parseStringToDate(endDate);
            medicalRecords = medicalRecordService.findByPatientIdAndAppointmentDateBetween(id, dateStart, dateEnd);
        } else {
            medicalRecords = medicalRecordService.findAllByDoctorId(id);
        }
        return medicalRecords;
    }

    @PostMapping("/patient/{patientId}/appointment")
    public MedicalRecord makeAppointmentToDoctor(@PathVariable Integer patientId,
                                                 @RequestBody AppointmentDTO appointment
    ) {
        //todo -> send an email that you booked time to visit doctor
        LocalDateTime appointmentDate = parseStringToDate(appointment.getDay(), appointment.getHour());
        MedicalRecord medicalRecord = MedicalRecord.builder()
                .patientId(patientId)
                .doctorId(appointment.getDoctorId())
                .appointmentDate(appointmentDate)
                .createdAt(appointmentDate)
                .updatedAt(appointmentDate)
                .build();
        return medicalRecordService.save(medicalRecord);
    }


    private Date parseStringToDate(String date) throws ParseException {
        return date == null
                ? new Date()
                : new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    private LocalDateTime parseStringToDate(String day, String hour) {
        return LocalDateTime.parse(String.format("%s %s", day, hour), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
