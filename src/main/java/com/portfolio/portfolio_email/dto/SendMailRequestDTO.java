package com.portfolio.portfolio_email.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendMailRequestDTO {
    String name;
    String from;
    String message;
}
