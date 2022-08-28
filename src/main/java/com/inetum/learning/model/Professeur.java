package com.inetum.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Professeur {

    @Id
    @Column(name = "profesor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professeur;

    @Column(name = "nombre")
    private String prenomProfesseur;

    @Column(name = "apellido")
    private String nomProfesseur;

    @Column(name = "correo")
    private String emailProfesseur;

    @Column(name = "descripcion")
    private String descProfesseur;

    @Column(name = "detalle")
    private String detailProfesseur;

    private String imgurl;

    public Professeur(String prenomProfesseur, String nomProfesseur, String emailProfesseur, String descProfesseur, String imgurl) {
        this.prenomProfesseur = prenomProfesseur;
        this.nomProfesseur = nomProfesseur;
        this.emailProfesseur = emailProfesseur;
        this.descProfesseur = descProfesseur;
        this.imgurl = imgurl;
    }
    public Professeur(String detailProfeseur) {
        this.detailProfesseur = detailProfeseur;
    }
}

