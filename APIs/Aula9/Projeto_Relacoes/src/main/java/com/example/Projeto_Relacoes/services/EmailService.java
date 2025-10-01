package com.example.Projeto_Relacoes.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String to, String nome) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Bem-vindo à nossa Livraria!");
        message.setText("Olá " + nome + ",\n\nObrigado por se cadastrar em nosso sistema! Estamos felizes em ter você conosco.\n\nAbraços,\nEquipe Livraria");
        mailSender.send(message);
    }
}
