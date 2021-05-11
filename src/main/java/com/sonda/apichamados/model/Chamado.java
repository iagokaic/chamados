package com.sonda.apichamados.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sonda.apichamados.enums.StatusChamado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
public class Chamado {

    @Id
    private String id;

    @NotBlank(message = "O campo matrícula do servidor não pode ser vazio")
    private String matriculaServidor;

    @NotBlank(message = "O campo metodo relatado não pode ser vazio")
    private String metodoRelatado;

    @NotBlank(message = "O campo descricao não pode ser vazio")
    private String descricao;

    private boolean desmembramento;

    @Enumerated(EnumType.STRING)
    private StatusChamado status;

    @ManyToOne
    private User tecnico;

    @ManyToOne
    private User analista;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataSolicitacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataAbertura;

    public Chamado() { }

    public Chamado(String matriculaServidor, String metodoRelatado, String descricao, boolean desmembramento, StatusChamado status, User tecnico, Date dataSolicitacao) {
        this.matriculaServidor = matriculaServidor;
        this.metodoRelatado = metodoRelatado;
        this.descricao = descricao;
        this.desmembramento = desmembramento;
        this.status = status;
        this.tecnico = tecnico;
        this.dataSolicitacao = dataSolicitacao;
    }
}
