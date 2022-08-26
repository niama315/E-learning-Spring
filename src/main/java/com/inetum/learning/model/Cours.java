package com.inetum.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curso")
public class Cours {
    @Id
    @Column(name = "curso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cours;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nomCours;

    @Column(name = "descripcion")
    private String descriptionCours;

    @Column(name = "detalle")
    private String detailCours;

    @Column(name = "dificultad")
    private String dificulteCours;

    @Column(name = "url")
    private String urlCours;

    private String imgurl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profesor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Professeur professeur;

    public Cours(String nomCours, String descriptionCours, String detailCours, String dificulteCours, String urlCours, String imgurl, Professeur professeur) {
        this.nomCours = nomCours;
        this.descriptionCours = descriptionCours;
        this.detailCours = detailCours;
        this.dificulteCours = dificulteCours;
        this.urlCours = urlCours;
        this.imgurl = imgurl;
        this.professeur = professeur;
    }
}
