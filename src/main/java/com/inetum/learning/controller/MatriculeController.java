package com.inetum.learning.controller;

import com.inetum.learning.auth.User;
import com.inetum.learning.auth.UserRepository;
import com.inetum.learning.model.Cours;
import com.inetum.learning.repositories.CoursRepository;
import com.inetum.learning.services.core.impl.MatriculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/matricula")
@PreAuthorize("hasRole('ROLE_USER')")
public class MatriculeController {

    private MatriculeService matriculaService;
    private UserRepository userRepository;
    private CoursRepository cursoRepository;

    @Autowired
    public MatriculeController(MatriculeService matriculaService, UserRepository userRepository, CoursRepository cursoRepository) {
        this.matriculaService = matriculaService;
        this.userRepository = userRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/save/{id_curso}")
    public String saveMatricula(@PathVariable Long id_curso, Authentication authentication, Model model) {
        try {
            String username = authentication.getName();
            matriculaService.createMatricula(id_curso, username);
            User user = userRepository.findByUsername(username);
            Cours curso = cursoRepository.findById(id_curso).get();
            model.addAttribute("curso", curso);
            model.addAttribute("user", user);
            return "matricula-success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
