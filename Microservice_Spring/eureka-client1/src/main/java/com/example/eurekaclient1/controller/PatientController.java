package com.example.eurekaclient1.controller;

import com.example.eurekaclient1.entity.Patient;
import com.example.eurekaclient1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Integer id){
        return patientService.findById(id);
    }


}
