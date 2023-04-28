package com.example.eurekaclient2.controller;

import com.example.eurekaclient2.entity.MedicalRecord;
import com.example.eurekaclient2.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping("/users")
    public List<MedicalRecord> getUsers(){
        return medicalRecordService.findAllPatientsByDoctorId(1);
    }

}
