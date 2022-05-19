package br.com.arthur.managment.sensediapullrequests.controller;

import br.com.arthur.managment.sensediapullrequests.model.dto.ArticleDto;
import br.com.arthur.managment.sensediapullrequests.model.dto.ArticleResponse;
import br.com.arthur.managment.sensediapullrequests.model.dto.Image;
import br.com.arthur.managment.sensediapullrequests.model.entity.ArticleModel;
import br.com.arthur.managment.sensediapullrequests.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final ArticleRepository repository;

    private final MongoOperations mongoOperations;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Image> upload(@RequestBody MultipartFile image) {
//        var file = new File("/home/arthur/IdeaProjects/html-css/blog-arthur/img/" + Objects.requireNonNull(image.getOriginalFilename()));
//        var dest = new File("/home/arthur/IdeaProjects/html-css/blog-arthur/img/back");
//        boolean isCreated = dest.mkdir();
//        var files = new File("/home/arthur/IdeaProjects/html-css/blog-arthur/img/back",image.getOriginalFilename());
//        System.out.println(isCreated);

        var path = "img/" + Objects.requireNonNull(image.getOriginalFilename());
        System.out.println(path);
        return ResponseEntity.ok(new Image(image.getOriginalFilename(), path));
    }

    @PostMapping(value = "/save-post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody ArticleDto article) {

        var save = repository.save(new ArticleModel(article));
        return ResponseEntity.ok().body(save);

    }

    @GetMapping(value = "/buscar/{titleId}")
    public ResponseEntity<?> findPage(@PathVariable String titleId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(titleId));
        List<ArticleModel> articleModels = mongoOperations.find(query, ArticleModel.class, "service-modal.article");
        if (articleModels.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        articleModels.forEach(e -> {
            var title = e.getTitle().split("_");
            e.setTitle(title[0]);

        });
        System.out.println(articleModels);
        return ResponseEntity.ok(new ArticleResponse(articleModels.get(0)));
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<ArticleResponse>> findAllPosts() {
        List<ArticleModel> articleModels = mongoOperations.findAll(ArticleModel.class, "service-modal.article");
        if (articleModels.size() == 0) {
            return ResponseEntity.notFound().build();
        }
//        articleModels.forEach(e -> {
//            String replace = e.getArticle().replace("#", "");
//            e.setArticle(replace);
//        });
        var respArticleList = articleModels.stream().map(ArticleResponse::new).collect(Collectors.toList());
        System.out.println(articleModels);
        return ResponseEntity.ok(respArticleList);
    }
}
