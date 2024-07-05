package com.learning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private String accountType;
    private Double accountBalance;
    private String approved;

    @ManyToOne
    private Customer customer;

    // getters and setters
}
