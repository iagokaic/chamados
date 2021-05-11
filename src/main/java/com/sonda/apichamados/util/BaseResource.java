package com.sonda.apichamados.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface BaseResource <E, E1>{
    public ResponseEntity<E1> inserir(E body, UriComponentsBuilder uriBuilder);
    public ResponseEntity<E1> alterar(String id, E body, UriComponentsBuilder uriBuilder);
    public void excluir(String id);
    public List<E1> listar();
    public E1 selecionar(String id);
}
