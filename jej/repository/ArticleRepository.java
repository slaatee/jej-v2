package com.jeanneeetjean.jej.repository;

import com.jeanneeetjean.jej.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

    Optional<Article> findByNom(String nom);
}
