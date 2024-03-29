package com.inetum.learning.repositories;

import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    Cours findByNomCours(String nombre);
    List<Cours> findAllByProfesseur(Professeur profesor);
}
