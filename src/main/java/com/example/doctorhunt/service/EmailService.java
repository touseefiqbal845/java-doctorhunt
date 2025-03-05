package com.example.doctorhunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetPasswordEmail(String toEmail, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Reset Your Password");
        message.setText("Click the link to reset your password: http://localhost:8080/reset-password?token=" + token);

        mailSender.send(message);
    }
}
