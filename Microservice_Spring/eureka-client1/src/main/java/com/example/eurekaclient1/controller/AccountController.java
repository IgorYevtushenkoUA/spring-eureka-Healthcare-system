package com.example.eurekaclient1.controller;

import com.example.eurekaclient1.dto.PatientDTO;
import com.example.eurekaclient1.entity.Patient;
import com.example.eurekaclient1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app")
public class AccountController {

    @Autowired
    PatientService patientService;

    @GetMapping("/account/patients")
    public List<Patient> getPatients() {
        return patientService.findAll();
    }

    @GetMapping("/account/patients/{id}")
    public Patient getPatient(@PathVariable String id) {
        return patientService.findById(UUID.fromString(id));
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = Patient.builder()
                .firstName(patientDTO.getFirstName())
                .lastName(patientDTO.getLastName())
                .dateOfBirth(patientDTO.getDateOfBirth())
                .gender(patientDTO.getGender())
                .email(patientDTO.getEmail())
                .phone(patientDTO.getPhone())
                .address(patientDTO.getAddress())
                .city(patientDTO.getCity())
                .region(patientDTO.getRegion())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return patientService.save(patient);
    }


}
