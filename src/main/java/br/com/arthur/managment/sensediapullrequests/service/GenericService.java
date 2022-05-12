package br.com.arthur.managment.sensediapullrequests.service;

import br.com.arthur.managment.sensediapullrequests.repositories.GenericRepository;
import br.com.arthur.managment.sensediapullrequests.util.Convertible;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public interface GenericService<T extends Convertible<DTO>,DTO, ID> extends GenericRepository<T,ID> {


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
