package com.jeanneeetjean.jej.dto;

import com.jeanneeetjean.jej.model.Colis;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class ColisDto {

    private Integer id;
    private String nom;
    private String texte;
    private String mail;
    private String phone;
    private String date;

    public static ColisDto fromEntity(Colis colis){
        if(colis==null){
            return null;
        }
        return ColisDto.builder()
                .id(colis.getId())
                .date(colis.getDate())
                .mail(colis.getMail())
                .nom(colis.getNom())
                .phone(colis.getPhone())
                .build();
    }
    public static Colis toEntity(ColisDto colisDto){
        if(colisDto==null){
            return null;
        }
        Colis colis = new Colis();
        colis.setId(colis.getId());
        colis.setNom(colis.getNom());
        colis.setMail(colis.getMail());
        colis.setPhone(colis.getPhone());
        colis.setDate(colis.getDate());
        return colis;
    }
}
