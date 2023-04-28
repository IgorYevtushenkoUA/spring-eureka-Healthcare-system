package com.example.eurekaclient1.service;

import com.example.eurekaclient1.entity.Patient;
import com.example.eurekaclient1.repository.PatientRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Patient save(Patient patient){return patientRepository.save(patient);}

    public Patient findById(UUID id){
        return patientRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
