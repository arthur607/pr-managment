package br.com.arthur.managment.sensediapullrequests.controller;

import br.com.arthur.managment.sensediapullrequests.model.dto.ArticleDto;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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

        var path = "blog-arthur/img/" + Objects.requireNonNull(image.getOriginalFilename());
        System.out.println(path);
        return ResponseEntity.ok(new Image(image.getOriginalFilename(), path));
    }

    @PostMapping(value = "/save-post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody ArticleDto article) {
        var save = repository.save(new ArticleModel(article));
        return ResponseEntity.ok().body(save);

    }

    @GetMapping(value = "/blog/{titleId}", produces = MediaType.TEXT_HTML_VALUE)
    public String findPage(HttpServletRequest req, HttpServletResponse resp, @PathVariable String titleId) {
        resp.setContentType(MediaType.TEXT_HTML_VALUE);
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(titleId));
        List<ArticleModel> articleModels = mongoOperations.find(query, ArticleModel.class, "service-modal.article");
        if (articleModels.size() == 0) {
            resp.setStatus(404);
        }
//        try {
              //  resp.sendRedirect(String.format("http://localhost:5500/article/%s/blog.html", titleId));
//            resp.sendRedirect("http://localhost:5500/"+titleId+"/blog-arthur/html/blog.html");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
        return String.format("http://localhost:5500/article/%s/blog.html", titleId);
    }
}
