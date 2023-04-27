package com.example.notificationservice.messaging;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private String name;
    private String surname;
    private Date appointmentDate;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment [name=" + name + ", surname=" + surname + ", Date=" + appointmentDate
                + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
