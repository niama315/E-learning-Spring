package com.inetum.learning.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "nom")
    private String nom;
    @Column(name = "email")
    private String email;
    private String detail;
    private String imgurl;
    @Column(name = "date_sing_up")
    private LocalDate date;

    public User(String username, String password, String nombre, String apellido, String email, String imgurl, LocalDate fecha) {
        this.username = username;
        this.password = password;
        this.prenom = nombre;
        this.nom = apellido;
        this.email = email;
        this.imgurl = imgurl;
        this.date = fecha;
    }

    public User(String detalle) {
        this.detail = detalle;
    }
}
