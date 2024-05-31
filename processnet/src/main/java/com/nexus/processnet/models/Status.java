package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    AGUARDANDO("Aguardando"),
    EM_ANALISE("Em Analise"),
    CONCLUIDO("Concluido");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
