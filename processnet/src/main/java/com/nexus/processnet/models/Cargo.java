package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Cargo {
    VISTORIADOR("Vistoriador"),
    ANALISTA("Analista"),
    GESTOR("Gestor");

    private final String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
