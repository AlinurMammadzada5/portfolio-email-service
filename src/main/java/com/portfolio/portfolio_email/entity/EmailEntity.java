package com.portfolio.portfolio_email.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "emails")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "email_id")
    private UUID emailId;

    @Column(nullable = false, name = "email_name")
    private String emailName;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false,name = "email_content")
    private String emailContent;

}
