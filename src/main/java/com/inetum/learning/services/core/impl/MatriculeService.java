package com.inetum.learning.services.core.impl;

import com.inetum.learning.auth.User;
import com.inetum.learning.auth.UserRepository;
import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Matricule;
import com.inetum.learning.repositories.CoursRepository;
import com.inetum.learning.repositories.MatriculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MatriculeService {


    private MatriculeRepository matriculeRepository;
    private CoursRepository coursRepository;
    private UserRepository userRepository;

    @Autowired
    public MatriculeService(MatriculeRepository matriculaRepository, CoursRepository cursoRepository, UserRepository userRepository) {
        this.matriculeRepository = matriculaRepository;
        this.coursRepository = cursoRepository;
        this.userRepository = userRepository;
    }

    public void createMatricula(Long id_curso, String username) throws Exception {
        Cours curso = coursRepository.findById(id_curso).get();
        User user = userRepository.findByUsername(username);

        if (null != matriculeRepository.findByCoursAndUser(curso, user)) {
            throw new Exception("Ya se encuentra matriculado en este curso");
        }
        LocalDate date = LocalDate.now();
        Matricule matricula = new Matricule(date, user, curso);
        matriculeRepository.save(matricula);
    }
}
