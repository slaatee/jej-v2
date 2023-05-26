package com.jeanneeetjean.jej.controller;

import com.jeanneeetjean.jej.controller.api.UtilisateurApi;
import com.jeanneeetjean.jej.dto.ChangerDeMotDePasseDto;
import com.jeanneeetjean.jej.dto.UtilisateurDto;
import com.jeanneeetjean.jej.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController (UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto changerMotDePasse(ChangerDeMotDePasseDto dto) {
        return utilisateurService.changerMotDePasse(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByMail(String mail) {
        return utilisateurService.findByMail(mail);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll() ;
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
