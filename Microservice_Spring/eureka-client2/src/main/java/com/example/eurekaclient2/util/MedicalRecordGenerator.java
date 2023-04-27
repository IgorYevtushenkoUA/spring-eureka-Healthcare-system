package com.example.eurekaclient2.util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MedicalRecordGenerator {

    public static void main(String[] args) {
        // Connect to MongoDB

        var mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
                        .uuidRepresentation(UuidRepresentation.STANDARD)
                        .build());
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

    private static String generateRandomUUID() {
        return UUID.randomUUID().toString();
    }

    private static List<String> patientsUUIDs = List.of(
            "34ddd7f8-4825-45dd-bd7a-ca397a6223ab",
            "76721478-6913-4c47-8d4b-a94ef873279e",
            "3d99b17d-b230-4a21-aa94-0fcf1df06b76",
            "3df5a390-1966-4ed7-9a3c-cee354123c81",
            "4f23e1de-2443-4dae-b0d3-c4c3683dc710",
            "93f71c54-7fc5-49a1-88ab-2f52746f423b",
            "c455f2fc-d014-4165-a652-893a87e3574b",
            "7e2ba400-82e6-4e2d-9891-ba1c4c29a40f",
            "de1a7e70-b9e5-467c-b916-dac8ecc652cd",
            "542b835b-1581-4754-9884-1cac8c55b821"
    );

    private static int getRandomNumberBetween(int num1, int num2) {
        return (int) (Math.random() * num2);
    }

    private static Document generateMedicalRecord(int index) {
        var record = new Document("_id", UUID.randomUUID().toString())
                .append("patient_id", patientsUUIDs.get(getRandomNumberBetween(1,10)))
                .append("doctor_id", (int) (Math.random() * 2) + 1)
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