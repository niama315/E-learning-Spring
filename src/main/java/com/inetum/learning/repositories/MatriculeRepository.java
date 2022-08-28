package com.inetum.learning.repositories;

import com.inetum.learning.auth.User;
import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Matricule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculeRepository extends JpaRepository<Matricule, Long> {

    List<Matricule> findAllByCours(Cours curso);
    List<Matricule> findAllByUser(User user);
    Matricule findByCoursAndUser(Cours curso, User user);
}
