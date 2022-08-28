package com.inetum.learning.service.core.impl;

import com.inetum.learning.dto.CoursDto;
import com.inetum.learning.model.Cours;
import com.inetum.learning.model.Professeur;
import com.inetum.learning.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {
    private CoursRepository CoursRepository;

    @Autowired
    public CoursService(CoursRepository cursoRepository) {
        this.CoursRepository = cursoRepository;
    }

    public void create(CoursDto cursoDto) throws Exception{
        if (null != CoursRepository.findByNomCours(cursoDto.getNomCours())) {
            throw new Exception("Un cours avec le nom existe déjà " + cursoDto.getNomCours());
        }
        String nomCurso = cursoDto.getNomCours();
        String descCurso = cursoDto.getDescriptionCours();
        String detalleCurso = cursoDto.getDetailCours();
        String difCurso = cursoDto.getDificulteCours();
        String urlCurso = cursoDto.getUrlCours();
        String imgurl = cursoDto.getImgurl();
        Professeur profesor = cursoDto.getProfesseur();
        Cours curso = new Cours(nomCurso, descCurso, detalleCurso, difCurso, urlCurso, imgurl, profesor);

        CoursRepository.save(curso);
    }

    public void update(Cours curso, Long id_curso) {
        Cours currentCurso = CoursRepository.findById(id_curso).get();

        currentCurso.setNomCours(curso.getNomCours());
        currentCurso.setDescriptionCours(curso.getDescriptionCours());
        currentCurso.setDetailCours(curso.getDetailCours());
        currentCurso.setDificulteCours(curso.getDificulteCours());
        currentCurso.setUrlCours(curso.getUrlCours());
        currentCurso.setImgurl(curso.getImgurl());
        currentCurso.setProfesseur(curso.getProfesseur());

        CoursRepository.save(currentCurso);

    }

    public void delete(Cours curso) { CoursRepository.delete(curso); }


    public List<Cours> getAll() {
        return CoursRepository.findAll();
    }

}
