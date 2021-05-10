package com.sonda.apichamados.repository;

import com.sonda.apichamados.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
