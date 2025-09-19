package com.Aula5.ProjetoZoo.ApiZoologico.services;

import com.Aula5.ProjetoZoo.ApiZoologico.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String destinatario, String assunto, String corpo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destinatario);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);

        mailSender.send(mensagem);
    }

    public void enviarRelatorioAtualizacao(Animal animal) {
        String destinatario = animal.getCuidador().getEmail();
        String assunto = "Atualização do Animal: " + animal.getNome();

        String corpo = """
            O animal foi atualizado com as seguintes informações:
            
            Nome: %s
            Espécie: %s
            Idade: %d anos
            
            Cuidador Responsável: %s
            Contato: %s
        """.formatted(
                animal.getNome(),
                animal.getEspecie(),
                animal.getIdade(),
                animal.getCuidador().getNome(),
                animal.getCuidador().getTelefone()
        );

        sendEmail(destinatario, assunto, corpo);
    }
}
