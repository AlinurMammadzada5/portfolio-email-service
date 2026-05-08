package com.portfolio.portfolio_email.controller;

import com.portfolio.portfolio_email.dto.SendMailRequestDTO;
import com.portfolio.portfolio_email.dto.SendMailResponseDTO;
import com.portfolio.portfolio_email.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("send_email")
    public ResponseEntity<SendMailResponseDTO> sendMailToUser(@RequestBody SendMailRequestDTO request){
        System.out.println("cname : "+ request.getName());
        System.out.println("cfrom : "+request.getFrom());
        System.out.println("cmessage : "+request.getMessage());

        SendMailResponseDTO response = userService.sendMail(request);

        return ResponseEntity.ok(response);
    }
}
