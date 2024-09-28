package com.learn.ticketsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Department department;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 20, message = "Description must be at least 20 characters long")
    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "ticket")
    @JsonIgnore
    private List<Conversation> conversations;



    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public enum Status {
        OPEN, CLOSED, IN_PROGRESS
    }

    public enum Department {
        SALES, TECH, FINANCE
    }

}
