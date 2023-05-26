package com.jeanneeetjean.jej.dto;

import com.jeanneeetjean.jej.model.Visite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VisiteDto {

    private Integer id;
    private String nom;
    private String texte;
    private String mail;
    private String phone;
    private String date;

    public static VisiteDto fromEntity(Visite visite){
        if(visite==null){
            return null;
        }
        return VisiteDto.builder()
                .id(visite.getId())
                .date(visite.getDate())
                .mail(visite.getMail())
                .nom(visite.getNom())
                .phone(visite.getPhone())
                .build();
    }
    public static Visite toEntity(VisiteDto visiteDto){
        if(visiteDto==null){
            return null;
        }
       Visite visite = new Visite();
        visite.setId(visite.getId());
        visite.setNom(visite.getNom());
        visite.setMail(visite.getMail());
        visite.setPhone(visite.getPhone());
        visite.setDate(visite.getDate());
        return visite;
    }

}
