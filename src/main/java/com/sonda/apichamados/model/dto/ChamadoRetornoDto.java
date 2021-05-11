package com.sonda.apichamados.model.dto;

import com.sonda.apichamados.model.Chamado;
import lombok.Getter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ChamadoRetornoDto {

    private String id;

    private String matriculaServidor;

    private String metodoRelatado;

    private String descricao;

    private String status;

    private boolean desmembramento;

    private Date dataSolicitacao;

    private Date dataAbertura;

    private UserRetornoDto tecnico;

    public ChamadoRetornoDto() {
    }

    public ChamadoRetornoDto (Chamado chamado) {
        this.id = chamado.getId();
        this.matriculaServidor = chamado.getMatriculaServidor();
        this.metodoRelatado = chamado.getMetodoRelatado();
        this.descricao = chamado.getDescricao();
        this.status = chamado.getStatus().getDescricao();
        this.desmembramento = chamado.isDesmembramento();
        this.dataSolicitacao = chamado.getDataSolicitacao();
        this.dataAbertura = chamado.getDataAbertura();
        this.tecnico = new UserRetornoDto(chamado.getTecnico());
    }

    public static List<ChamadoRetornoDto> converter(List<Chamado> chamados) {
        return chamados.stream().map(ChamadoRetornoDto::new).collect(Collectors.toList());
    }
}
