package com.entities;

import java.io.Serializable;

public enum EMessages implements Serializable {

    EMAIL_ADDRESS_EXIST("Cette adresse email existe déja"),
    LOGIN_EXIST("username already exist try another login"),
    EMAIL_ADDRESS_MATRICULE_EXIST("Adresse Emil ou Matricule déjà existent"),
    AUCUN_PARAMETRE("Aucun paramètre n'est spécifié dans la requête");

    private String name;

    EMessages(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}