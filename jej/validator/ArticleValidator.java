package com.jeanneeetjean.jej.validator;

import com.jeanneeetjean.jej.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'article");
            errors.add("Veuillez renseigner le titre de l'article");
            errors.add("Veuillez renseigner le texte de l'article");
            errors.add("Veuillez renseigner le lien de l'article");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'article");
        }
        if (!StringUtils.hasLength(dto.getText())) {
            errors.add("Veuillez renseigner le texte de l'article");
        }
        if (!StringUtils.hasLength(dto.getTitre())) {
            errors.add("Veuillez renseigner le titre de l'article");
        }
        if (!StringUtils.hasLength(dto.getLien())) {
            errors.add("Veuillez renseigner le lien de l'article");
        }

        return errors;
    }
}
