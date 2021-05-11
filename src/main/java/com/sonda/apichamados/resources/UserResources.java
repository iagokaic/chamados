package com.sonda.apichamados.resources;

import com.sonda.apichamados.model.User;
import com.sonda.apichamados.model.dto.UserDto;
import com.sonda.apichamados.model.dto.UserRetornoDto;
import com.sonda.apichamados.services.UserService;
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
@RequestMapping(value = "user")
public class UserResources implements BaseResource<UserDto, UserRetornoDto> {

    @Autowired
    private UserService userService;

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<UserRetornoDto> inserir(@Valid @RequestBody UserDto body, UriComponentsBuilder uriBuilder) {
        User user = userService.inserir(body.converter());
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserRetornoDto(user));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<UserRetornoDto> alterar(@PathVariable("id") String id, @Valid @RequestBody UserDto body, UriComponentsBuilder uriBuilder) {
        User user = userService.alterar(id, body.converter());
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserRetornoDto(user));
    }

    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    @Override
    public void excluir(@PathVariable("id") String id) {
        userService.excluir(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @Override
    public List<UserRetornoDto> listar() {
        return UserRetornoDto.converter(userService.listar());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @Override
    public UserRetornoDto selecionar(@PathVariable("id") String id) {
        return new UserRetornoDto(userService.selecionar(id));
    }
}
