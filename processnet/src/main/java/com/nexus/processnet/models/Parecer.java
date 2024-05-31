package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Parecer {
    AGUARDANDO("Aguardando"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado");

    private final String descricao;

    Parecer(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
