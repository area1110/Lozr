/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.module;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import model.User;

public class MailSending {

    final String EMAIL_ADDRESS = "nguyenkhanhhuy2001@gmail.com";
    final String EMAIL_PASS = "khanhhuy1";

    public void send(String to, String sub,
            String msg, final String user, final String pass) {
        //create an instance of Properties Class   
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
        }
    }

    public void sendNewPassToMail(User user, String newpass) {

        String subject = "Request to reset password";
        String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <h3 style=\"color: blue;\">Hello, " + user.getLoginName() + "</h3>\n"
                + "    <div><i>** This is an automated message -- please do not reply as you will not receive a response. **</i></div>\n"
                + "    <div>This message is in response to your request to reset your account password from <b>LOZR forum. </b>"
                + "Please use the new password below to login.</div>\n"
                + "    <div>Your password is: <b>" + newpass + "</b></div>\n"
                + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        send(user.getEmailAddress(), subject, message, EMAIL_ADDRESS, EMAIL_PASS);
    }
}
