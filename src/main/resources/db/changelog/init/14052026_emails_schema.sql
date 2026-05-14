--liquibase formatted sql

--changeset liquibase:14052026_emails_schema
CREATE TABLE IF NOT EXISTS emails (
    email_id UUID PRIMARY KEY default gen_random_uuid(),
    email VARCHAR(150) NOT NULL,
    email_name VARCHAR(255) NOT NULL,
    email_content TEXT NOT NULL
    );