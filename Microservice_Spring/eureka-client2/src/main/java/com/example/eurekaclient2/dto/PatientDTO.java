package com.example.eurekaclient2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private char gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String region;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
