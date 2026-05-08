package com.portfolio.portfolio_email.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMailResponseDTO {
    @JsonProperty("isSent")
    boolean isSent;
}
