package com.sonda.apichamados.repository;

import com.sonda.apichamados.model.Chamado;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChamadoRepository extends MongoRepository<Chamado, ObjectId> {
}
