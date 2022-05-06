package br.com.arthur.managment.sensediapullrequests.controller;

import br.com.arthur.managment.sensediapullrequests.model.dto.PullRequestDto;
import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import br.com.arthur.managment.sensediapullrequests.service.PullRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PullRequestController implements GenericController<PullRequestDto, PullRequestModal> {

    private final PullRequestService service;

    @Override
    public ResponseEntity<PullRequestDto> save(PullRequestModal requestModal) {
        requestModal.setDateTime(LocalDateTime.now());
        System.out.println("gravado com sucesso =>  " + requestModal);

        return ResponseEntity.ok(service.save(requestModal).convert());
    }

    @Override
    public ResponseEntity<Set<PullRequestDto>> findAllData() {
       final Set<PullRequestModal> allPrs = service.findAll();
        System.out.println("Registros recuperados com sucesso! ");
        return ResponseEntity.ok(allPrs.stream().map(PullRequestModal::convert).collect(Collectors.toSet()));
    }

    @Override
    public ResponseEntity<PullRequestDto> findById(Long id) {


        return ResponseEntity.ok(service.findById(id).convert());
    }

}
