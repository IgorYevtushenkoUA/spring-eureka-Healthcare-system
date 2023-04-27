package com.example.eurekaclient2.entity;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "medical_records")
public class MedicalRecord {

    @Id
    private String id;

    @Field("patient_id")
    private Integer patientId;

    @Field("doctor_id")
    private Integer doctorId;

    @Field("appointment_date")
    private Date appointmentDate;

    private String diagnosis;

    private String treatment;

    private List<Medication> medications;

    @Field("lab_results")
    private List<LabResult> labResults;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
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

        @Field("test_name")
        private String testName;

        private String result;

        private String units;
    }
}
