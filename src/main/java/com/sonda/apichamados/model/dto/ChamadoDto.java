package com.sonda.apichamados.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sonda.apichamados.enums.StatusChamado;
import com.sonda.apichamados.model.Chamado;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class ChamadoDto {

    @NotBlank(message = "O campo matrícula do servidor não pode ser vazio")
    private String matriculaServidor;

    @NotBlank(message = "O campo metodo relatado não pode ser vazio")
    private String metodoRelatado;

    @NotBlank(message = "O campo descricao não pode ser vazio")
    private String descricao;

    @NotBlank(message = "O campo status não pode ser vazio")
    private String status;

    @NotBlank(message = "O campo desmembramento não pode ser vazio")
    private boolean desmembramento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull(message = "O campo publicação não pode ser nulo")
    private Date dataSolicitação;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataAbertura;

    @NotNull
    private UserDto tecnico;

    public ChamadoDto() {
    }

    public Chamado converter() {
        return new Chamado(matriculaServidor, metodoRelatado, descricao, desmembramento, StatusChamado.valueOf(status), tecnico.converter(), dataSolicitação);
    }
}
