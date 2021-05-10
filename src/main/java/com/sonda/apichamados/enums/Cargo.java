package com.sonda.apichamados.enums;

public enum Cargo {
    N1("SERVICEDESK"),
    N2("FIELDSERVICE");

    private String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
