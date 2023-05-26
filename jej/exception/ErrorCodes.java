package com.jeanneeetjean.jej.exception;

public enum ErrorCodes {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    ARTICLE_ALREADY_IN_USE(1002),

    COLIS_NOT_FOUND(1100),
    COLIS_NOT_VALID(1101),
    COLIS_ALREADY_IN_USE(1102),

    PANIER_NOT_FOUND(1200),
    PANIER_NOT_VALID(1201),
    PANIER_ALREADY_IN_USE(1202),

    VISITE_NOT_FOUND(1300),
    VISITE_NOT_VALID(1301),
    VISITE_ALREADY_IN_USE(1302),

    UTILISATEUR_NOT_FOUND(12000),
    UTILISATEUR_NOT_VALID(12001),
    UTILISATEUR_ALREADY_EXISTS(12002),
    UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID(12003), BAD_CREDENTIALS(15200);




    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
