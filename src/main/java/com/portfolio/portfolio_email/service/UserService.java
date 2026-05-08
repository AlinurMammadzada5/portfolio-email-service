package com.portfolio.portfolio_email.service;

import com.portfolio.portfolio_email.dto.SendMailRequestDTO;
import com.portfolio.portfolio_email.dto.SendMailResponseDTO;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final MailService mailService;
    private static final String MAIL_ADDRESS = "alinurmammadzada1@gmail.com";

    public SendMailResponseDTO sendMail(SendMailRequestDTO request) {
        System.out.println("name : "+ request.getName());
        System.out.println("from : "+request.getFrom());
        System.out.println("message : "+request.getMessage());
        try {
            mailService.sendHtml(MAIL_ADDRESS, request.getName(), combineFromAndMessage(request.getFrom(), request.getMessage()));
            System.out.println("We have came passed sendHTML");
            return SendMailResponseDTO
                    .builder()
                    .isSent(true)
                    .build();
        } catch (MessagingException ex){
            return SendMailResponseDTO
                    .builder()
                    .isSent(false)
                    .build();
        }
    }

    private String combineFromAndMessage(String from, String message){
        return from+"\n"+message;
    }



}
