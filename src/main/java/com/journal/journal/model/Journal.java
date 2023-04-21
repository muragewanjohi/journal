package com.journal.journal.model;

import lombok.*;

import jakarta.persistence.*;

// Annotations
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String journalDate;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private String accountDr;
    @Column(nullable = false)
    private String accountCr;
    @Column(nullable = false)
    private String status;
}
