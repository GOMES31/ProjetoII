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

    @Column(name = "theme")
    private String theme;


    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client expositor;

    // Cria uma tabela chamada "visits" que associa os clientes que participaram na exposicao à exposicao
    @ManyToMany
    @JoinTable(
            name = "visits",
            joinColumns = @JoinColumn(name = "exposition_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> participants;
}
