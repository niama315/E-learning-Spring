package com.inetum.learning.controller;

import com.inetum.learning.auth.User;
import com.inetum.learning.auth.UserRepository;
import com.inetum.learning.dto.CoursDto;
import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Professeur;
import com.inetum.learning.repositories.CoursRepository;
import com.inetum.learning.repositories.MatriculeRepository;
import com.inetum.learning.repositories.ProfesseurRepository;
import com.inetum.learning.services.core.impl.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CoursController {
    private CoursService cursoService;
    private CoursRepository cursoRepository;
    private MatriculeRepository matriculaRepository;
    private UserRepository userRepository;
    private ProfesseurRepository profesorRepository;

    @Autowired
    public CoursController(CoursService cursoService, CoursRepository cursoRepository,
                           MatriculeRepository matriculaRepository, UserRepository userRepository, ProfesseurRepository profesorRepository) {
        super();
        this.cursoService = cursoService;
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
        this.userRepository = userRepository;
        this.profesorRepository = profesorRepository;
    }

    @GetMapping("/add/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addCours(@PathVariable Long id_profesor, Model model) {
        try {
            Professeur current = profesorRepository.findById(id_profesor).get();
            model.addAttribute("curso", new CoursDto());
            model.addAttribute("profesor", current);
            return "cursos/curso-add";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/add/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveCours(@PathVariable Long id_profesor, CoursDto curso, Model model) {
        try {
            Professeur current = profesorRepository.findById(id_profesor).get();
            curso.setProfesseur(current);
            cursoService.create(curso);
            return "redirect:/cursos";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }

    }

    @GetMapping("/edit/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getCoursForUpdate(@PathVariable Long id_curso, Model model) {
        try {
            Cours cursoActual = cursoRepository.findById(id_curso).get();
            model.addAttribute("curso", cursoActual);
            return "cursos/curso-edit";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/edit/{id_profesor}/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCours(@PathVariable Long id_profesor, @PathVariable Long id_curso, Cours curso, Model model, RedirectAttributes attributes) {

        try {
            Professeur currentProfesseur = profesorRepository.findById(id_profesor).get();
            curso.setProfesseur(currentProfesseur);

            cursoService.update(curso, id_curso);
            attributes.addAttribute("id_curso", id_curso);

            return "redirect:/cursos/{id_curso}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping
    public String getCourssList(Model model) {
        List<Cours> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "cursos/cursos";
    }

    @GetMapping("/delete/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCours(@PathVariable Long id_curso, Model model) {
        try {
            Cours cursoActual = cursoRepository.findById(id_curso).get();
            cursoService.delete(cursoActual);

            return "redirect:/cursos";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping("/{id_curso}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getCoursDetail(@PathVariable Long id_curso, Authentication authentication, Model model) {
        String username = authentication.getName();
        Boolean matriculado = false;
        try {
            Cours curso = cursoRepository.findById(id_curso).get();
            User user = userRepository.findByUsername(username);
            if (null != matriculaRepository.findByCursoAndUsuario(curso, user)) {
                matriculado = true;
            }
            model.addAttribute("curso", curso);
            model.addAttribute("matriculado", matriculado);
            return "cursos/curso-detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
