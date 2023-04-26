CREATE TABLE patients (
                          id INT PRIMARY KEY,
                          first_name VARCHAR(50),
                          last_name VARCHAR(50),
                          date_of_birth DATE,
                          gender CHAR(1),
                          email VARCHAR(255),
                          phone VARCHAR(20),
                          address VARCHAR(255),
                          city VARCHAR(50),
                          region VARCHAR(50),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE patients ADD role VARCHAR(50);

INSERT INTO patients (id, first_name, last_name, date_of_birth, gender, email, phone, address, city, region, role)
VALUES
    (1, 'John', 'Doe', '1990-01-01', 'M', 'john.doe@example.com', '555-555-1234', '123 Main St', 'Anytown', 'CA', 'DOCTOR'),
    (2, 'Jane', 'Doe', '1995-05-05', 'F', 'jane.doe@example.com', '555-555-5678', '456 Oak Ave', 'Anytown', 'CA', 'DOCTOR'),
    (3, 'Bob', 'Smith', '1985-10-10', 'M', 'bob.smith@example.com', '555-555-9012', '789 Elm St', 'Anytown', 'CA', 'PATIENT'),
    (4, 'Alice', 'Johnson', '1992-02-02', 'F', 'alice.johnson@example.com', '555-555-3456', '321 Pine St', 'Anytown', 'CA', 'PATIENT'),
    (5, 'Mike', 'Miller', '1978-07-07', 'M', 'mike.miller@example.com', '555-555-7890', '654 Maple St', 'Anytown', 'CA', 'PATIENT'),
    (6, 'Amy', 'Davis', '1989-09-09', 'F', 'amy.davis@example.com', '555-555-2345', '987 Oak St', 'Anytown', 'CA', 'PATIENT'),
    (7, 'Tom', 'Wilson', '1980-04-04', 'M', 'tom.wilson@example.com', '555-555-6789', '456 Pine Ave', 'Anytown', 'CA', 'PATIENT'),
    (8, 'Sarah', 'Jones', '1998-11-11', 'F', 'sarah.jones@example.com', '555-555-0123', '789 Elm Ave', 'Anytown', 'CA', 'PATIENT'),
    (9, 'David', 'Brown', '1991-03-03', 'M', 'david.brown@example.com', '555-555-4567', '123 Maple Ave', 'Anytown', 'CA', 'PATIENT'),
    (10, 'Emily', 'Taylor', '1987-06-06', 'F', 'emily.taylor@example.com','555-555-3387', '123 Apple Elb', 'Anytown', 'CA', 'PATIENT')


ALTER TABLE patients DROP role VARCHAR(50);

CREATE TABLE doctors (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(50),
                         last_name VARCHAR(50),
                         email VARCHAR(255),
                         speciality VARCHAR(255),
                         phone VARCHAR(20),
                         address VARCHAR(255),
                         city VARCHAR(50),
                         region VARCHAR(50),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO doctors (first_name, last_name, email, speciality, phone, address, city, region)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'Cardiologist', '123-456-7890', '123 Main St', 'Anytown', 'Anyregion'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'Pediatrician', '555-123-4567', '456 Elm St', 'Anycity', 'Anyregion'),
    ('Bob', 'Johnson', 'bob.johnson@example.com', 'Dermatologist', '555-555-5555', '789 Maple St', 'Anystate', 'Anyregion');


