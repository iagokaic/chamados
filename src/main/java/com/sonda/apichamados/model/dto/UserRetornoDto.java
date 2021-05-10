package com.sonda.apichamados.model.dto;

import com.sonda.apichamados.enums.Cargo;
import com.sonda.apichamados.model.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserRetornoDto {

    private String id;
    private String nome;
    private String cargo;

    public UserRetornoDto() {}

    public UserRetornoDto(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.cargo = user.getCargo().getDescricao();
    }

    public UserRetornoDto(String id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public static List<UserRetornoDto> converter(List<User> users) {
        return users.stream().map(UserRetornoDto::new).collect(Collectors.toList());
    }
}
