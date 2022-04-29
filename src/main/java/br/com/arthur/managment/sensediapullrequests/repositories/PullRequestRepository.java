package br.com.arthur.managment.sensediapullrequests.repositories;

import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullRequestRepository extends MongoRepository<PullRequestModal, Long> {
}
