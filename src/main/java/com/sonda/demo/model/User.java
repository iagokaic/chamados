package com.sonda.demo.model;

import com.sonda.demo.enums.Cargo;
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
