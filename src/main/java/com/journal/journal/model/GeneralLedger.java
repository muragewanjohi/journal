package com.journal.journal.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String postingDate;
    @Column(nullable = false)
    private String accountName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private String postingType;
    @Column(nullable = false)
    private Long journalId;

}
