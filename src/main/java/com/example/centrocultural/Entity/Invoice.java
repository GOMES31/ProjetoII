package com.example.centrocultural.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "invoice_date")
    // Gera automaticamente a data sempre que é tirada uma nova fatura
    @CreationTimestamp
    private Date date;

    @Column(name = "NIF")
    private String NIF;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

}
