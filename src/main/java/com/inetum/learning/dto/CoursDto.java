package com.inetum.learning.dto;

import com.inetum.learning.model.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoursDto {
    private String nomCours;
    private String descriptionCours;
    private String dificulteCours;
    private String detailCours;
    private String urlCours;
    private String imgurl;
    private Professeur professeur;
}
