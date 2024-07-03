package com.learning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer{

    @Id
    private Integer accountNumber;
    private Double balance;
    private String secretQuestion;
    private String secretAnswer;
    private List<Integer> transactionId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

}
