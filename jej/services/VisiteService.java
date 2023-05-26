package com.jeanneeetjean.jej.services;

import com.jeanneeetjean.jej.dto.PanierDto;
import com.jeanneeetjean.jej.dto.VisiteDto;

import java.util.List;

public interface VisiteService {

    VisiteDto save(VisiteDto dto);

    VisiteDto findById(Integer id);

    VisiteDto findByNom (String nom);

    VisiteDto findByMail (String mail);

    List<VisiteDto> findAll();

    void delete(Integer id);
}
