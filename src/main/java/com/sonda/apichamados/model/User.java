package com.sonda.apichamados.model;

import com.sonda.apichamados.enums.Cargo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class User {

    @MongoId
    private String id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

}
