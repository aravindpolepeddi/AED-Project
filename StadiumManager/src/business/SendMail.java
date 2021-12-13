/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Customer.Customer;
import business.Customer.Ticket;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author deepv
 */
public class SendMail {

    public void sendMail(String to, String id, String eventName, Ticket ticket, Customer customer) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("stadiopvtltd@gmail.com", "Stadio1234");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stadioStudios@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            if (id != null && customer != null && ticket != null) {
                message.setSubject("Booking confirmation. ID: " + id);
                message.setText("Dear " + customer.getFullName() + " ,\nYour booking for event " + eventName + " has been confirmed.\n\nRegards,\nDiego Stadium Booking Admin");
            } else {
                message.setSubject("Thanks for registering with us!");
                message.setText("You have successfully registered yourself!");
            }
            Transport.send(message);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
