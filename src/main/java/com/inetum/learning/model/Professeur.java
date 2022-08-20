package com.inetum.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professeur")
public class Professeur {

    @Id
    @Column(name = "professeur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professeur;

    @Column(name = "prenom")
    private String prenomProfesseur;

    @Column(name = "nom")
    private String nomProfesseur;

    @Column(name = "email")
    private String emailProfesseur;

    @Column(name = "description")
    private String descProfesseur;

    @Column(name = "detail")
    private String detailProfesor;

    private String imgurl;

    public Professeur(String prenomProfesseur, String nomProfesseur, String emailProfesseur, String descProfesseur, String imgurl) {
        this.prenomProfesseur = prenomProfesseur;
        this.nomProfesseur = nomProfesseur;
        this.emailProfesseur = emailProfesseur;
        this.descProfesseur = descProfesseur;
        this.imgurl = imgurl;
    }
    public Professeur(String detailProfeseur) {
        this.detailProfesor = detailProfeseur;
    }
}

