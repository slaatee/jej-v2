package com.jeanneeetjean.jej.services;

import com.jeanneeetjean.jej.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByNom(String nom);

    List<ArticleDto> findAll();

    void delete(Integer id);
    
}
