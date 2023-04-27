package com.example.eurekaclient2.service;

import com.example.eurekaclient2.entity.MedicalRecord;
import com.example.eurekaclient2.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> findAllByDoctorId(Integer doctorId) {
        List<MedicalRecord> mr= medicalRecordRepository.findAllByDoctorId(doctorId);
        System.out.printf("service lol medical record for doctor_id=1 = [%d]", mr.size());
        return mr;
    }

    public List<MedicalRecord> findByDoctorIdAndAppointmentDateGreaterThanEqual(
            Integer doctorId,
            Date startDate
    ) {
        return medicalRecordRepository.findByDoctorIdAndAppointmentDateGreaterThanEqual(doctorId, startDate);
    }

    public List<MedicalRecord> findByDoctorIdAndAppointmentDateBetween(
            Integer doctorId,
            Date startDate,
            Date endDate
    ) {
        return medicalRecordRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, startDate, endDate);
    }

    public List<MedicalRecord> findAllByPatientId(Integer patientId) {
        return medicalRecordRepository.findAllByPatientId(patientId);
    }

    public List<MedicalRecord> findByPatientIdAndAppointmentDateGreaterThanEqual(
            Integer patientId,
            Date startDate
    ) {
        return medicalRecordRepository.findByPatientIdAndAppointmentDateGreaterThanEqual(patientId, startDate);
    }

    public List<MedicalRecord> findByPatientIdAndAppointmentDateBetween(
            Integer patientId,
            Date startDate,
            Date endDate
    ) {
        return medicalRecordRepository.findByPatientIdAndAppointmentDateBetween(patientId, startDate, endDate);
    }

    public MedicalRecord save(MedicalRecord medicalRecord){
        return medicalRecordRepository.save(medicalRecord);
    }

}
