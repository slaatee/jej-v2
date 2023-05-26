package com.jeanneeetjean.jej.dto;

import com.jeanneeetjean.jej.model.Article;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String nom;

    private String titre;

    private String text;

    private String lien;

    private String photo;

    public static ArticleDto fromEntity(Article article){
        if (article == null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .nom(article.getNom())
                .titre(article.getTitre())
                .text(article.getText())
                .lien(article.getLien())
                .photo(article.getPhoto())
                .build();
    }
    public static Article toEntity(ArticleDto articleDto){
        if(articleDto ==null){
            return null;
        }
        Article article = new Article();
            article.setId(article.getId());
            article.setTitre(article.getTitre());
            article.setPhoto(article.getPhoto());
            article.setLien(article.getLien());
            article.setDate(article.getDate());
            article.setText(article.getText());
            return article;
    }
}
