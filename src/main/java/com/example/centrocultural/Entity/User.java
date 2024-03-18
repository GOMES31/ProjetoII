package com.example.centrocultural.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty(message = "Username cannot be empty")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private Role role;

}
