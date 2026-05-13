package com.portfolio.portfolio_email.service;

import com.portfolio.portfolio_email.dto.SendMailRequestDTO;
import com.portfolio.portfolio_email.dto.SendMailResponseDTO;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final MailService mailService;

    @Value("${mail.name}")
    private String MAIL_ADDRESS;

    public SendMailResponseDTO sendMail(SendMailRequestDTO request) {
        try {
            System.out.println(MAIL_ADDRESS);
            mailService.sendHtml(MAIL_ADDRESS, request.getName(), combineFromAndMessage(request.getFrom(), request.getMessage()));
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
