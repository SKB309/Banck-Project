package com.springBoot.BankAccount.BankAccount.Service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(String email, String subject, String message) {
    }
//    private final JavaMailSender javaMailSender;
//
//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void sendEmail(String toEmail, String subject, String message) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//        javaMailSender.send(mailMessage);
//    }
}
