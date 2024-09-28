package com.learn.ticketsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.ticketsystem.validation.EmailDomain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @EmailDomain(domain = "company.com")
    private String email;

    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets;
}
