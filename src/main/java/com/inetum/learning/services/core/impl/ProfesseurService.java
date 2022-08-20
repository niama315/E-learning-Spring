package com.inetum.learning.services.core.impl;

import com.inetum.learning.dto.ProfesseurDto;
import com.inetum.learning.model.Professeur;
import com.inetum.learning.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfesseurService {

    private ProfesseurRepository professeurRepository;

    @Autowired
    public ProfesseurService(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public void create(ProfesseurDto profesotDto) {
        String nombre = profesotDto.getPrenomProfesseur();
        String apellido = profesotDto.getNomProfesseur();
        String correo = profesotDto.getEmailProfesseur();
        String descripcion = profesotDto.getDescProfesseur();
        String imgurl = profesotDto.getImgurl();
        Professeur profesor = new Professeur(nombre, apellido, correo, descripcion, imgurl);

        professeurRepository.save(profesor);
    }

    public List<Professeur> getAll() {
        return professeurRepository.findAll();
    }

    public void update(Professeur profesor) {
        Professeur currentProfesseur = professeurRepository.findById(profesor.getId_professeur()).get();

        currentProfesseur.setNomProfesseur(profesor.getNomProfesseur());
        currentProfesseur.setNomProfesseur(profesor.getNomProfesseur());
        currentProfesseur.setEmailProfesseur(profesor.getEmailProfesseur());
        currentProfesseur.setDescProfesseur(profesor.getDescProfesseur());
        currentProfesseur.setImgurl(profesor.getImgurl());

        professeurRepository.save(currentProfesseur);
    }

    public void patch(Professeur profesor) {
        Professeur current = professeurRepository.findById(profesor.getId_professeur()).get();

        current.setDetailProfesor(profesor.getDetailProfesor());

        professeurRepository.save(current);
    }

    public void delete(Professeur profesor) {
        professeurRepository.delete(profesor);
    }

}
