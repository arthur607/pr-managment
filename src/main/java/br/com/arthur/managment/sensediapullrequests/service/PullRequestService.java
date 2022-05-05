package br.com.arthur.managment.sensediapullrequests.service;

import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import br.com.arthur.managment.sensediapullrequests.repositories.PullRequestRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class PullRequestService implements GenericService<PullRequestModal,Long> {

    private final PullRequestRepository repository;

    public PullRequestService(PullRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public MongoRepository<PullRequestModal, Long> getRepository() {
        return repository;
    }

    @Override
    public PullRequestModal findById(Long aLong) {
        return GenericService.super.findById(aLong);
    }

    @Override
    public Set<PullRequestModal> findAll() {
        return GenericService.super.findAll();
    }
    @Override
    public PullRequestModal save(PullRequestModal requestModal) {
        requestModal.setDateTime(LocalDateTime.now());
        System.out.println("gravado com sucesso =>  " + requestModal);

        return GenericService.super.save(requestModal);
    }

    @Override
    public void delete(PullRequestModal object) {
        GenericService.super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        GenericService.super.deleteById(aLong);
    }
}
