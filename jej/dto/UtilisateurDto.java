package com.jeanneeetjean.jej.dto;

import com.jeanneeetjean.jej.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {


    private Integer id;

    private String nom;

    private String prenom;

    private String mail;

    private Instant dateDeNaissance;

    private String motDePasse;

    private String photo;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .mail(utilisateur.getMail())
                .motDePasse(utilisateur.getMotDePasse())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .photo(utilisateur.getPhoto())
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setMail(dto.getMail());
        utilisateur.setMotDePasse(dto.getMotDePasse());
        utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
        utilisateur.setPhoto(dto.getPhoto());

        return utilisateur;

    }


}
