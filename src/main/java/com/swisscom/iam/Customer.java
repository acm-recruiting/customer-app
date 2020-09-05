package com.swisscom.iam;

import java.time.LocalDateTime;

public class Customer {

    private String id;
    private String name;
    private MailingAddress mailingAddress;
    private String emailAddress;
    private LocalDateTime validUntil;

    public Customer(String id, String name, MailingAddress mailingAddress, String emailAddress) {
        this.id = id;
        this.name = name;
        this.mailingAddress = mailingAddress;
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }
}