package com.example.centrocultural.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "visits")
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "visit_name")
    private String name;

    @Column(name = "visit_date")
    // @CreationTimestamp - Remover o comentário para gerar a data automaticamente
    private Date date;

    @Column(name = "place")
    private String visitPlace;

    @Column(name = "theme")
    private String theme;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    @ManyToMany(mappedBy = "visits")
    private Set<Exposition> expositions;
}
