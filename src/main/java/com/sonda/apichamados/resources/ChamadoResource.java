package com.sonda.apichamados.resources;

import com.sonda.apichamados.model.Chamado;
import com.sonda.apichamados.model.dto.ChamadoDto;
import com.sonda.apichamados.model.dto.ChamadoRetornoDto;
import com.sonda.apichamados.services.ChamadoService;
import com.sonda.apichamados.util.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource implements BaseResource<ChamadoDto, ChamadoRetornoDto> {

    @Autowired
    private ChamadoService chamadoService;

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<ChamadoRetornoDto> inserir(@Valid @RequestBody ChamadoDto body, UriComponentsBuilder uriBuilder) {
        Chamado chamado = chamadoService.inserir(body.converter());
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ChamadoRetornoDto(chamado));
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<ChamadoRetornoDto> alterar(@PathVariable("id") String id, @Valid @RequestBody ChamadoDto body, UriComponentsBuilder uriBuilder) {
        Chamado chamado = chamadoService.alterar(id, body.converter());
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ChamadoRetornoDto(chamado));
    }

    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    @Override
    public void excluir(@PathVariable("id") String id) {
        chamadoService.excluir(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @Override
    public List<ChamadoRetornoDto> listar() {
        return ChamadoRetornoDto.converter(chamadoService.listar());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @Override
    public ChamadoRetornoDto selecionar(@PathVariable("id") String id) {
        return new ChamadoRetornoDto(chamadoService.selecionar(id));
    }
}
