package br.com.arthur.managment.sensediapullrequests.model.entity;

import br.com.arthur.managment.sensediapullrequests.model.dto.ArticleDto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "service-modal.article")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticleModel {

    private String title;
    private String article;
    private String bannerImage;

    public ArticleModel (ArticleDto articleDto) {
       this.title = articleDto.getTitle();
       this.article = articleDto.getArticle();
       this.bannerImage = articleDto.getBannerImage();
    }
}
