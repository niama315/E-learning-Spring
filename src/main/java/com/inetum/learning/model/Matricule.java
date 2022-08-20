package com.inetum.learning.model;


import com.inetum.learning.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matricule")
public class Matricule {

    @Id
    @Column(name = "matricule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricule;

    @Column(name = "date")
    private LocalDate date_matricule;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cours_id", nullable = false)
    private Cours cours;

    public Matricule(LocalDate date_matricule, User user, Cours cours) {
        this.date_matricule = date_matricule;
        this.user = user;
        this.cours = cours;
    }
}
