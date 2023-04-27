drop table patients;

CREATE TABLE patients
(
    id            UUID,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    date_of_birth DATE,
    gender        CHAR(1),
    email         VARCHAR(255),
    phone         VARCHAR(20),
    address       VARCHAR(255),
    city          VARCHAR(50),
    region        VARCHAR(50),
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) PARTITION BY RANGE (date_of_birth);

CREATE TABLE patients_1900 PARTITION OF patients FOR VALUES FROM ('1900-01-01') TO ('1909-12-31');
CREATE TABLE patients_1910 PARTITION OF patients FOR VALUES FROM ('1910-01-01') TO ('1919-12-31');
CREATE TABLE patients_1920 PARTITION OF patients FOR VALUES FROM ('1920-01-01') TO ('1929-12-31');
CREATE TABLE patients_1930 PARTITION OF patients FOR VALUES FROM ('1930-01-01') TO ('1939-12-31');
CREATE TABLE patients_1940 PARTITION OF patients FOR VALUES FROM ('1940-01-01') TO ('1949-12-31');
CREATE TABLE patients_1950 PARTITION OF patients FOR VALUES FROM ('1950-01-01') TO ('1959-12-31');
CREATE TABLE patients_1960 PARTITION OF patients FOR VALUES FROM ('1960-01-01') TO ('1969-12-31');
CREATE TABLE patients_1970 PARTITION OF patients FOR VALUES FROM ('1970-01-01') TO ('1979-12-31');
CREATE TABLE patients_1980 PARTITION OF patients FOR VALUES FROM ('1980-01-01') TO ('1989-12-31');
CREATE TABLE patients_1990 PARTITION OF patients FOR VALUES FROM ('1990-01-01') TO ('1999-12-31');
CREATE TABLE patients_2000 PARTITION OF patients FOR VALUES FROM ('2000-01-01') TO ('2009-12-31');
CREATE TABLE patients_2010 PARTITION OF patients FOR VALUES FROM ('2010-01-01') TO ('2019-12-31');
CREATE TABLE patients_2020 PARTITION OF patients FOR VALUES FROM ('2020-01-01') TO ('2029-12-31');

INSERT INTO patients (id, first_name, last_name, date_of_birth, gender, email, phone, address, city, region)
VALUES
    ('34ddd7f8-4825-45dd-bd7a-ca397a6223ab', 'John', 'Doe', '1990-01-01', 'M', 'john.doe@example.com', '555-555-1234', '123 Main St', 'Anytown', 'CA'),
    ('76721478-6913-4c47-8d4b-a94ef873279e', 'Jane', 'Doe', '1995-05-05', 'F', 'jane.doe@example.com', '555-555-5678', '456 Oak Ave', 'Anytown', 'CA'),
    ('3d99b17d-b230-4a21-aa94-0fcf1df06b76', 'Bob', 'Smith', '1985-10-10', 'M', 'bob.smith@example.com', '555-555-9012', '789 Elm St', 'Anytown', 'CA'),
    ('3df5a390-1966-4ed7-9a3c-cee354123c81', 'Alice', 'Johnson', '1992-02-02', 'F', 'alice.johnson@example.com', '555-555-3456', '321 Pine St', 'Anytown', 'CA'),
    ('4f23e1de-2443-4dae-b0d3-c4c3683dc710', 'Mike', 'Miller', '1978-07-07', 'M', 'mike.miller@example.com', '555-555-7890', '654 Maple St', 'Anytown', 'CA'),
    ('93f71c54-7fc5-49a1-88ab-2f52746f423b', 'Amy', 'Davis', '1989-09-09', 'F', 'amy.davis@example.com', '555-555-2345', '987 Oak St', 'Anytown', 'CA'),
    ('c455f2fc-d014-4165-a652-893a87e3574b', 'Tom', 'Wilson', '1980-04-04', 'M', 'tom.wilson@example.com', '555-555-6789', '456 Pine Ave', 'Anytown', 'CA'),
    ('7e2ba400-82e6-4e2d-9891-ba1c4c29a40f', 'Sarah', 'Jones', '1998-11-11', 'F', 'sarah.jones@example.com', '555-555-0123', '789 Elm Ave', 'Anytown', 'CA'),
    ('de1a7e70-b9e5-467c-b916-dac8ecc652cd', 'David', 'Brown', '1991-03-03', 'M', 'david.brown@example.com', '555-555-4567', '123 Maple Ave', 'Anytown', 'CA'),
    ('542b835b-1581-4754-9884-1cac8c55b821', 'Emily', 'Taylor', '1987-06-06', 'F', 'emily.taylor@example.com','555-555-3387', '123 Apple Elb', 'Anytown', 'CA');

select tableoid::regclass, * from patients;


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


