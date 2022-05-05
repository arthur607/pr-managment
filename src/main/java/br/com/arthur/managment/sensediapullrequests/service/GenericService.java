package br.com.arthur.managment.sensediapullrequests.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public interface GenericService<T, ID> {

    MongoRepository<T, ID> getRepository();

    default T findById(ID id) {
        return getRepository().findById(id).orElseThrow();
    }

    default Set<T> findAll() {
        return new HashSet<>(getRepository().findAll());
    }

    default T save(T object) {
        return getRepository().save(object);
    }

    default void delete(T object) {
        getRepository().delete(object);
    }

    default void deleteById(ID id) {
        T obj = getRepository().findById(id).orElseThrow();
        getRepository().delete(obj);
    }
}
