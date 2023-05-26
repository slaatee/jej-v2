package com.jeanneeetjean.jej.services;


import com.jeanneeetjean.jej.dto.ColisDto;

import java.util.List;

public interface ColisService {

    ColisDto save(ColisDto dto);

    ColisDto findById(Integer id);

    ColisDto findByNom (String nom);

    ColisDto findByMail (String mail);

    List<ColisDto> findAll();
    void delete(Integer id);
}
