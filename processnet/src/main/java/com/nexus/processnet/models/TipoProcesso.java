package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoProcesso {
    VISTORIA("Vistoria"),
    ANALISE("Analise");

    private final String descricao;

    TipoProcesso(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}

