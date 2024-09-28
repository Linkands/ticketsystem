package com.learn.ticketsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    private Sender sender;

    @NotBlank(message = "Messaage cannot be empty")
    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Sender {
        CUSTOMER, SUPPORT
    }


}
