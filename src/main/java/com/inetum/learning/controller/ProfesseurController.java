package com.inetum.learning.controller;

import com.inetum.learning.dto.ProfesseurDto;
import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Professeur;
import com.inetum.learning.repositories.CoursRepository;
import com.inetum.learning.repositories.ProfesseurRepository;
import com.inetum.learning.services.core.impl.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesseurController {
    private ProfesseurService professeurService;
    private ProfesseurRepository professeurRepository;
    private CoursRepository coursRepository;

    @Autowired
    public ProfesseurController(ProfesseurService professeurService, ProfesseurRepository professeurRepository,
                              CoursRepository coursRepository) {
        this.professeurService = professeurService;
        this.professeurRepository = professeurRepository;
        this.coursRepository = coursRepository;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addProfesseur(Model model) {
        model.addAttribute("profesor", new ProfesseurDto());
        return "profesores/profesor-add";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String saveProfesseur(ProfesseurDto profesor) {
        professeurService.create(profesor);

        return "redirect:/profesores";
    }

    @GetMapping("/edit/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getProfesseurForUpdate(@PathVariable Long id_profesor,
                                       Model model) {
        try {
            Professeur profesorActual = professeurRepository.findById(id_profesor).get();
            model.addAttribute("profesor", profesorActual);
            return "profesores/profesor-edit";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/update/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProfesseur(@PathVariable Long id_profesor,
                                 Professeur professeur, RedirectAttributes attributes, Model model){

        try {
            Professeur currentProfesseur = professeurRepository.findById(id_profesor).get();
            currentProfesseur.setPrenomProfesseur(professeur.getPrenomProfesseur());
            currentProfesseur.setNomProfesseur(professeur.getNomProfesseur());
            currentProfesseur.setEmailProfesseur(professeur.getEmailProfesseur());
            currentProfesseur.setDescProfesseur(professeur.getDescProfesseur());
            currentProfesseur.setImgurl(professeur.getImgurl());

            professeurService.update(professeur);
            attributes.addAttribute("id_profesor", id_profesor);

            return "redirect:/profesores/{id_profesor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/patch/{id_profesor}")
    public String patchProfesseur(@PathVariable Long id_profesor, Professeur profesor, RedirectAttributes attributes, Model model) {

        try {
           Professeur current = professeurRepository.findById(id_profesor).get();
            current.setDetailProfesseur(profesor.getDetailProfesseur());
            professeurService.patch(current);

            attributes.addAttribute("id_profesor", id_profesor);
            return "redirect:/profesores/{id_profesor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProfesseursList(Model model) {
        List<Professeur> profesores = professeurService.getAll();
        model.addAttribute("profesores", profesores);
        return "profesores/profesores";
    }

    @GetMapping("/delete/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProfesseur(@PathVariable Long id_profesor, Model model) {
        try {
            Professeur profesorActual = professeurRepository.findById(id_profesor).get();
            professeurService.delete(profesorActual);

            return "redirect:/profesores";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping("/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProfesseurDetail(@PathVariable Long id_profesor, Model model) {
        try {
            Professeur profesor = professeurRepository.findById(id_profesor).get();
            model.addAttribute("profesor", profesor);
            List<Cours> cursos = coursRepository.findAllByProfesseur(profesor);
            model.addAttribute("cursos", cursos);
            return "profesores/profesor-detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
