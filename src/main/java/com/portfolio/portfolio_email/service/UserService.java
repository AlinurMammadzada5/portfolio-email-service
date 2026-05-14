package com.portfolio.portfolio_email.service;

import com.portfolio.portfolio_email.dto.SendMailRequestDTO;
import com.portfolio.portfolio_email.dto.SendMailResponseDTO;
import com.portfolio.portfolio_email.entity.EmailEntity;
import com.portfolio.portfolio_email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final EmailRepository emailRepository;

    public SendMailResponseDTO sendMail(SendMailRequestDTO request) {
        EmailEntity email = EmailEntity
                .builder()
                .emailName(request.getName())
                .emailContent(request.getMessage())
                .email(request.getFrom())
                .build();

            emailRepository.save(email);

        return SendMailResponseDTO
                .builder()
                .isSent(true)
                .build();
    }

}
