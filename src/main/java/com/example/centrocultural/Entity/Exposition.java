package com.example.centrocultural.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "expositions")
@Data
public class Exposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "exposition_name")
    private String expName;

    @Column(name = "exposition_date")
    // @CreationTimestamp - Remover o comentário para gerar a data automaticamente
    private Date expDate;

    @Column(name = "place")
    private String expPlace;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    // Cria uma tabela chamada "timetables" que conecta as tabelas "visits" e "expositions"
    @ManyToMany
    @JoinTable(
            name = "timetables",
            joinColumns = @JoinColumn(name = "exposition_id"),
            inverseJoinColumns = @JoinColumn(name = "visit_id")
    )
    private Set<Visit> visits;
}
