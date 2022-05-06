package br.com.arthur.managment.sensediapullrequests.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenericRepository<T,ID> {

    MongoRepository<T, ID> getRepository();
}
