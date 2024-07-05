package com.learning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private String accountType;
    private String approved;

    @ManyToOne
    private Customer customer;

    // getters and setters
}