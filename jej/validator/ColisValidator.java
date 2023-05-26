package com.jeanneeetjean.jej.validator;


import com.jeanneeetjean.jej.dto.ColisDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ColisValidator {
    public static List<String> validate(ColisDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du colis");
            errors.add("Veuillez renseigner le mail du colis");
            errors.add("Veuillez renseigner le texte du colis");
            errors.add("Veuillez renseigner le numéro du colis");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du colis");
        }
        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("Veuillez renseigner le mail du colis");
        }
        if (!StringUtils.hasLength(dto.getTexte())) {
            errors.add("Veuillez renseigner le texte du colis");
        }
        if (!StringUtils.hasLength(dto.getPhone())) {
            errors.add("Veuillez renseigner le numéro de tel du colis");
        }

        return errors;
    }
}
