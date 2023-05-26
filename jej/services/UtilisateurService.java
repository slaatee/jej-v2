package com.jeanneeetjean.jej.services;

import com.jeanneeetjean.jej.dto.ChangerDeMotDePasseDto;
import com.jeanneeetjean.jej.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

    UtilisateurDto findByMail(String email);

    UtilisateurDto changerMotDePasse(
            ChangerDeMotDePasseDto dto);
}

