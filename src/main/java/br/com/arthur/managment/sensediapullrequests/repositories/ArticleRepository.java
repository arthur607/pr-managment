package br.com.arthur.managment.sensediapullrequests.repositories;

import br.com.arthur.managment.sensediapullrequests.model.entity.ArticleModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<ArticleModel, Long> {

    ArticleModel findByTitle(String articleId);
}
