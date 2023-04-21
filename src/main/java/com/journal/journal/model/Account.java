package com.journal.journal.model;

// Importing required classes

import jakarta.persistence.*;
import lombok.*;


// Annotations
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountID;
    @Column(nullable = false, unique = true)
    private String accountNo;
    @Column(nullable = false)
    private String accountName;
}
