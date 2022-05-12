package br.com.arthur.managment.sensediapullrequests.controller;

import br.com.arthur.managment.sensediapullrequests.model.dto.Image;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class BlogController {

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Image> upload(@RequestBody MultipartFile image){
        var path = "blog-arthur/img/" + Objects.requireNonNull(image.getOriginalFilename());
        System.out.println(path);
        return ResponseEntity.ok(new Image(image.getOriginalFilename(), path));
    }
}
