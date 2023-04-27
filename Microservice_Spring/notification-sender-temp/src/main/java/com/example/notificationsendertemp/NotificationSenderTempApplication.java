package com.example.notificationsendertemp;

import com.example.notificationservice.messaging.Appointment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.util.Date;

@SpringBootApplication
@EnableJms
public class NotificationSenderTempApplication {
    private static final String MESSAGE_QUEUE = "appointments";
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NotificationSenderTempApplication.class, args);
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        for (int i = 1; i <= 10; i++)
        {
            Appointment a = new Appointment();
            a.setAppointmentDate(new Date());
            a.setSurname("Malkov");
            a.setName("Yehor");
            a.setEmail("egorrchikk@gmail.com");

            System.out.println("Sending a message " + i);
            jmsTemplate.convertAndSend(MESSAGE_QUEUE, a);
        }
    }

}
