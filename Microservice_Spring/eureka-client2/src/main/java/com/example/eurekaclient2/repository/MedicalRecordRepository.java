package com.example.eurekaclient2.repository;

import com.example.eurekaclient2.entity.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {

    List<MedicalRecord> findAllByDoctorId(Integer doctorId);

    List<MedicalRecord> findByDoctorIdAndAppointmentDateGreaterThanEqual(
            Integer doctorId,
            Date startDate
    );

    List<MedicalRecord> findByDoctorIdAndAppointmentDateBetween(
            Integer doctorId,
            Date startDate,
            Date endDate
    );

    List<MedicalRecord> findAllByPatientId(Integer patientId);

    List<MedicalRecord> findByPatientIdAndAppointmentDateGreaterThanEqual(
            Integer patientId,
            Date startDate
    );

    List<MedicalRecord> findByPatientIdAndAppointmentDateBetween(
            Integer patientId,
            Date startDate,
            Date endDate
    );

}
