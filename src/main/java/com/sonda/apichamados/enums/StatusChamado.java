package com.sonda.apichamados.enums;

public enum StatusChamado {

    PENDENTE("Pendente"),
    ABERTO("Aberto"),
    CANCELADO("Cancelado");

    private String descricao;

    StatusChamado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
