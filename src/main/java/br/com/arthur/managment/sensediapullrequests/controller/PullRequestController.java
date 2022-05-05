package br.com.arthur.managment.sensediapullrequests.controller;

import br.com.arthur.managment.sensediapullrequests.model.dto.PullRequestDto;
import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import br.com.arthur.managment.sensediapullrequests.service.PullRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PullRequestController {

    private final PullRequestService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<PullRequestModal> save(@Valid @RequestBody PullRequestModal requestModal){
        requestModal.setDateTime(LocalDateTime.now());
        System.out.println("gravado com sucesso =>  " + requestModal);

       return ResponseEntity.ok(service.save(requestModal));
    }
    @GetMapping("/buscar")
    public ResponseEntity<Set<PullRequestDto>> findAll(){
        Set<PullRequestModal> allPrs = service.findAll();
        System.out.println("Registros recuperados com sucesso! ");
        return ResponseEntity.ok(allPrs.stream().map(PullRequestDto::new).collect(Collectors.toSet()));
    }
}
