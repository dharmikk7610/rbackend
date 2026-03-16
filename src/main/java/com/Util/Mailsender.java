package com.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mailsender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String email, String username) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("ROYAL TECHNOSOFT P LIMITED");
        message.setText(
            "Hello " + username + ",\n\n" +
            "Your appointment is confirmed.\n" +
            "Please check the website for more details.\n\n" +
            "Regards,\nRoyal Technosoft Pvt. Ltd."
        );

        javaMailSender.send(message);
    }
}

