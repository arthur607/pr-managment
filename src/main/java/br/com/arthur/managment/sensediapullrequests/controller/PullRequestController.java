package br.com.arthur.managment.sensediapullrequests.controller;

import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import br.com.arthur.managment.sensediapullrequests.repositories.PullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PullRequestController {

    private final PullRequestRepository pullRequestRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<PullRequestModal> save(@RequestBody PullRequestModal requestModal){
        System.out.println("gravado com sucesso =>  " + requestModal);
       return ResponseEntity.ok(pullRequestRepository.save(requestModal));
    }
}
