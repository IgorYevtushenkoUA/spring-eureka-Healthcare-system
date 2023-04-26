package com.example.eurekaclient2.controller;

import com.example.eurekaclient2.entity.MedicalRecord;
import com.example.eurekaclient2.service.MedicalRecordService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/medical-record")
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping("/patient")
    public List<MedicalRecord> getPatientMedicalRecords(){
        return medicalRecordService.findAllByDoctorId(1);
    }

}
