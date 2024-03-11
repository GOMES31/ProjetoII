package com.example.centrocultural.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Exposition> expositions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Visit> visits;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Invoice> invoices;





}