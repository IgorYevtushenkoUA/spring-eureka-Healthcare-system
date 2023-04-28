package com.example.eurekaclient2.controller;

import com.example.eurekaclient2.dto.AppointmentDTO;
import com.example.eurekaclient2.dto.PatientDTO;
import com.example.eurekaclient2.entity.MedicalRecord;
import com.example.eurekaclient2.service.MedicalRecordService;
import com.example.notificationservice.messaging.Appointment;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app")
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    JmsTemplate jmsTemplate;

    private static final String MESSAGE_QUEUE = "appointments";

    @GetMapping("/doctor/{id}/patients")
    public List<MedicalRecord> getPatientMedicalRecords(@PathVariable Integer id,
                                                        @RequestParam(required = false) String startDate,
                                                        @RequestParam(required = false) String endDate) throws ParseException {
        List<MedicalRecord> medicalRecords;
        if (startDate != null) {
            Date dateStart = parseStringToDate(startDate);
            Date dateEnd = parseStringToDate(endDate);
            medicalRecords = medicalRecordService.findAllPatientsByDoctorIdAndAppointmentDateBetween(id, dateStart, dateEnd);
        } else {
            medicalRecords = medicalRecordService.findAllPatientsByDoctorId(id);
        }
        return medicalRecords;
    }

    @PostMapping("/patient/{patientId}/appointment")
    public MedicalRecord makeAppointmentToDoctor(@PathVariable String patientId,
                                                 @RequestBody AppointmentDTO appointment
    ) {

        PatientDTO patientDTOInfo = new PatientDTO();

        List<ServiceInstance> instances = discoveryClient.getInstances("eclient1");
        if (instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String url = serviceInstance.getUri().toString();
            url = String.format("%s/app/account/patients/%s", url, patientId);
            System.out.println("url is :" + url);
            RestTemplate restTemplate = new RestTemplate();
            patientDTOInfo = restTemplate.getForObject(url, PatientDTO.class);
        }

        //send an email that you booked time to visit doctor

        Appointment a = new Appointment();
        a.setAppointmentDate(new Date());
        a.setSurname(patientDTOInfo.getLastName());
        a.setName(patientDTOInfo.getFirstName());
        a.setEmail(patientDTOInfo.getEmail());
        jmsTemplate.convertAndSend(MESSAGE_QUEUE, a);

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
