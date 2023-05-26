package com.jeanneeetjean.jej.services;

import com.jeanneeetjean.jej.dto.PanierDto;

import java.util.List;


public interface PanierService {

    PanierDto save(PanierDto dto);

    PanierDto findById(Integer id);

    PanierDto findByNom (String nom);

    PanierDto findByMail (String mail);

    List<PanierDto> findAll();

    void delete(Integer id);
}
