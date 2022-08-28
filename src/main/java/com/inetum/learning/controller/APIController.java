package com.inetum.learning.controller;


import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Professeur;
import com.inetum.learning.services.core.impl.CoursService;
import com.inetum.learning.services.core.impl.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private ProfesseurService profesorService;
    private CoursService cursoService;


    @Autowired
    public APIController(ProfesseurService profesorService, CoursService cursoService) {
        this.profesorService = profesorService;
        this.cursoService = cursoService;
    }

    @GetMapping("/professeurs")
    public List<Professeur> getAllProf() {
        return this.profesorService.getAll();
    }

    @GetMapping("/cours")
    public List<Cours> getAllCurso() {
        return this.cursoService.getAll();
    }
}
