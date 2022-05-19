package br.com.arthur.managment.sensediapullrequests.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class ArticleDto {

    private String title;
    private String article;
    private String bannerImage;

}
