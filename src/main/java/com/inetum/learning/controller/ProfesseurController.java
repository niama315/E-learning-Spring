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
@RequestMapping("/professeurs")
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
        model.addAttribute("professeur", new ProfesseurDto());
        return "professeurs/professeur-add";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String saveProfesseur(ProfesseurDto professeur) {
        professeurService.create(professeur);

        return "redirect:/professeurs";
    }

    @GetMapping("/edit/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getProfesseurForUpdate(@PathVariable Long id_professeur,
                                       Model model) {
        try {
            Professeur professeurActual = professeurRepository.findById(id_professeur).get();
            model.addAttribute("professeur", professeurActual);
            return "professeurs/professeur-edit";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/update/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProfesseur(@PathVariable Long id_professeur,
                                 Professeur professeur, RedirectAttributes attributes, Model model){

        try {
            Professeur currentProfesseur = professeurRepository.findById(id_professeur).get();
            currentProfesseur.setPrenomProfesseur(professeur.getPrenomProfesseur());
            currentProfesseur.setNomProfesseur(professeur.getNomProfesseur());
            currentProfesseur.setEmailProfesseur(professeur.getEmailProfesseur());
            currentProfesseur.setDescProfesseur(professeur.getDescProfesseur());
            currentProfesseur.setImgurl(professeur.getImgurl());

            professeurService.update(professeur);
            attributes.addAttribute("id_professeur", id_professeur);

            return "redirect:/profesores/{id_profesor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/patch/{id_professeur}")
    public String patchProfesseur(@PathVariable Long id_professeur, Professeur professeur, RedirectAttributes attributes, Model model) {

        try {
           Professeur current = professeurRepository.findById(id_professeur).get();
            current.setDetailProfesseur(professeur.getDetailProfesseur());
            professeurService.patch(current);

            attributes.addAttribute("id_profesor", id_professeur);
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
        List<Professeur> professeurs = professeurService.getAll();
        model.addAttribute("professeurs", professeurs);
        return "professeurs/professeurs";
    }

    @GetMapping("/delete/{id_professeur}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProfesseur(@PathVariable Long id_professeur, Model model) {
        try {
            Professeur professeurActual = professeurRepository.findById(id_professeur).get();
            professeurService.delete(professeurActual);

            return "redirect:/professeurs";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping("/{id_professeur}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProfesseurDetail(@PathVariable Long id_professeur, Model model) {
        try {
            Professeur professeur = professeurRepository.findById(id_professeur).get();
            model.addAttribute("professeur", professeur);
            List<Cours> cours = coursRepository.findAllByProfesor(professeur);
            model.addAttribute("cours", cours);
            return "professeurs/professeur-detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
