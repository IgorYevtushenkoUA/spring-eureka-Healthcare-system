package com.example.notificationservice.consumer;

import com.example.notificationservice.messaging.Appointment;
import com.example.notificationservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.text.SimpleDateFormat;

@Component
public class MessageReceiver
{
    private static final String MESSAGE_QUEUE = "appointments";

    @Autowired
    private EmailSenderService senderService;

    @JmsListener(destination = MESSAGE_QUEUE)
    public void receiveMessage(Appointment message)
    {
        System.out.println("Received " + message);
        var dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        var body = String.format("<div>Dear <b>%s %s</b>,</div><div>You have a new appointment on %s </div> <hr> <em>Best Regards, Healthcare Notification Service</em>",
                message.getSurname(), message.getName(), dateFormat.format(message.getAppointmentDate()));
        senderService.sendSimpleEmail(message.getEmail(),"Healthcare System: New Appointment", body);
//		if(product.getQuantity()%2 ==0) {
//			throw new RuntimeException();
//		}
    }
}