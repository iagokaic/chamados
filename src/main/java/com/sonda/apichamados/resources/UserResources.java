package com.sonda.apichamados.resources;

import com.sonda.apichamados.model.dto.UserDto;
import com.sonda.apichamados.model.dto.UserRetornoDto;
import com.sonda.apichamados.util.BaseResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserResources implements BaseResource<UserDto, UserRetornoDto> {

    @Override
    public ResponseEntity<UserRetornoDto> inserir(UserDto obj, UriComponentsBuilder uriBuilder) {
        return null;
    }

    @Override
    public ResponseEntity<UserRetornoDto> alterar(Long id, UserDto obj, UriComponentsBuilder uriBuilder) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }

    @Override
    public List<UserRetornoDto> listar() {
        return null;
    }

    @Override
    public UserRetornoDto selecionar(Long id) {
        return null;
    }
}
