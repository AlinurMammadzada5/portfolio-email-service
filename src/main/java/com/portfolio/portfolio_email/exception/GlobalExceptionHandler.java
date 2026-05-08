package com.portfolio.portfolio_email.exception;

import com.portfolio.portfolio_email.dto.ErrorDTO;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final String MESSAGE_ERROR_CODE = "SEND_MESSAGE_FAILED";
    private final String EXCEPTION_ERROR_CODE = "SEND_MESSAGE_FAILED";

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ErrorDTO> handleMessagingException(MessagingException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(MESSAGE_ERROR_CODE, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(EXCEPTION_ERROR_CODE, ex.getMessage()));
    }
}
