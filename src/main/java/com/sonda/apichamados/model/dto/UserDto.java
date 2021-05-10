package com.sonda.apichamados.model.dto;

import com.sonda.apichamados.enums.Cargo;
import com.sonda.apichamados.model.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserDto {

    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O campo cargo não pode ser vazio")
    private String cargo;

    public UserDto() {}

    public User converter() {
        return new User(nome, Cargo.valueOf(cargo));
    }

}
