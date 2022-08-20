package com.inetum.learning.repositories;

import com.inetum.learning.auth.User;
import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Matricule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricule, Long> {

    List<Matricule> findAllByCurso(Cours curso);
    List<Matricule> findAllByUsuario(User user);
    Matricule findByCursoAndUsuario(Cours curso, User user);
}
