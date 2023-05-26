package com.jeanneeetjean.jej.validator;


import com.jeanneeetjean.jej.dto.PanierDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PanierValidator {
    public static List<String> validate(PanierDto dto) {
        List<String> errors = new ArrayList<>();
        String s = "Panier";
        if (dto == null) {
            errors.add("Veuillez renseigner le nom du"+ s);
            errors.add("Veuillez renseigner le mail du"+ s);
            errors.add("Veuillez renseigner le texte du"+ s);
            errors.add("Veuillez renseigner le numéro du"+ s);
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du"+ s);
        }
        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("Veuillez renseigner le mail du"+ s);
        }
        if (!StringUtils.hasLength(dto.getTexte())) {
            errors.add("Veuillez renseigner le texte du"+ s);
        }
        if (!StringUtils.hasLength(dto.getPhone())) {
            errors.add("Veuillez renseigner le numéro de tel du"+ s);
        }

        return errors;
    }
}
