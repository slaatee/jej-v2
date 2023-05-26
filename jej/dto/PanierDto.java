package com.jeanneeetjean.jej.dto;

import com.jeanneeetjean.jej.model.Panier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanierDto {

    private Integer id;

    private String nom;

    private String texte;

    private String mail;

    private String phone;

    private String date;

    public static PanierDto fromEntity(Panier panier){
        if(panier ==null){
            return null;
        }
        return PanierDto.builder()
                .id(panier.getId())
                .date(panier.getDate())
                .mail(panier.getMail())
                .nom(panier.getNom())
                .phone(panier.getPhone())
                .texte(panier.getTexte())
                .build();
    }
    public static  Panier toEntity(PanierDto panierDto){
        if(panierDto==null){
            return null;
        }
        Panier panier= new Panier();
        panier.setId(panier.getId());
        panier.setDate(panier.getDate());
        panier.setMail(panier.getMail());
        panier.setNom(panier.getNom());
        panier.setTexte(panier.getTexte());
        panier.setPhone(panier.getPhone());
        return panier;
    }

}
