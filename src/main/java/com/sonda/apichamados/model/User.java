package com.sonda.apichamados.model;

import com.sonda.apichamados.enums.Cargo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O campo cargo não pode ser vazio")
    private Cargo cargo;

    public User() {};

    public User(String nome, Cargo cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }
}
