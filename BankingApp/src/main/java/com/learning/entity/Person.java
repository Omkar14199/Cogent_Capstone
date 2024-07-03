package com.learning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @OneToMany(mappedBy = "person")
    private Integer id;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String Email;
}
