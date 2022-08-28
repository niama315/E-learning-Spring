package com.inetum.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurDto {
    private String prenomProfesseur;
    private String nomProfesseur;
    private String emailProfesseur;
    private String descProfesseur;
    private String imgurl;
}
