package com.example.eurekaclient2.util;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;

public class MedicalRecordGenerator {

    public static void main(String[] args) {
        // Connect to MongoDB
        var mongoClient = MongoClients.create("mongodb://localhost:27017");
        var database = mongoClient.getDatabase("healthcare_system");
        var collection = database.getCollection("medical_records");

        // Generate and insert 100 medical records
        for (int i = 1; i <= 100; i++) {
            var record = generateMedicalRecord(i);
            collection.insertOne(record);
            System.out.println("Inserted record: " + record);
        }
        // Disconnect from MongoDB
        mongoClient.close();
    }

    private static Document generateMedicalRecord(int index) {
        var record = new Document("_id", index)
                .append("patient_id", (int)(Math.random()*10)+1)
                .append("doctor_id", (int)(Math.random()*2)+1)
                .append("appointment_date", new Date())
                .append("diagnosis", "diagnosis " + index)
                .append("treatment", "treatment " + index);

        var medications = new ArrayList<Document>();
        medications.add(new Document("name", "medication " + index)
                .append("dosage", "dosage " + index)
                .append("frequency", "frequency " + index));
        record.append("medications", medications);

        var labResults = new ArrayList<Document>();
        labResults.add(new Document("test_name", "test " + index)
                .append("result", "result " + index)
                .append("units", "units " + index));
        record.append("lab_results", labResults);

        record.append("created_at", new Date())
                .append("updated_at", new Date());

        return record;
    }
}