package com.example.eurekaclient2.entity;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "medical_records")
public class MedicalRecord {

    @Id
    private String id;

    private Integer patientId;

    private Integer doctorId;

    private Date appointmentDate;

    private String diagnosis;

    private String treatment;

    private List<Medication> medications;

    private List<LabResult> labResults;

    private Date createdAt;

    private Date updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Medication {

        private String name;

        private String dosage;

        private String frequency;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LabResult {

        private String testName;

        private String result;

        private String units;
    }
}
