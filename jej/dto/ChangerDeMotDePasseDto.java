package com.jeanneeetjean.jej.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerDeMotDePasseDto {
    private Integer id;

    private String motDePasse;

    private String confirmMotDePasse;
}
