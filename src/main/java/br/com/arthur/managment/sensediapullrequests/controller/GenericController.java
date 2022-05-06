package br.com.arthur.managment.sensediapullrequests.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Set;

public interface GenericController<C, R> {

    @PostMapping(value = "/cadastrar", produces = "application/json")
    ResponseEntity<C> save(@Valid @RequestBody R request);

    @GetMapping(value = "/buscar/todos", produces = "application/json")
    ResponseEntity<Set<C>> findAllData();

    @GetMapping(value = "/buscar/{id}", produces = "application/json")
    ResponseEntity<C> findById(@PathVariable(value = "id") Long id);
}
