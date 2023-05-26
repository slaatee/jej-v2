package com.jeanneeetjean.jej.controller.api;

import com.jeanneeetjean.jej.dto.ChangerDeMotDePasseDto;
import com.jeanneeetjean.jej.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jeanneeetjean.jej.utils.Constants.UTILISATEUR_ENDPOINT;

public interface UtilisateurApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    UtilisateurDto changerMotDePasse(@RequestBody ChangerDeMotDePasseDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{mail}")
    UtilisateurDto findByMail(@PathVariable("mail") String mail);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);
}
