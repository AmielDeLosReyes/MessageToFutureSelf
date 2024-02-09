package com.future.self.lesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("subject") String subject,
                            @RequestParam("message") String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("amielxavierdelosreyes@gmail.com"); // Set recipient email address
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        emailSender.send(mailMessage);
        return "redirect:/"; // Redirect back to the home page or any other page after sending email
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

