package br.com.arthur.managment.sensediapullrequests.model.dto;

import br.com.arthur.managment.sensediapullrequests.model.entity.ArticleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
public class ArticleResponse {

    private String title;
    private String article;
    private String bannerImage;
    private String createAt;

    public ArticleResponse(ArticleModel articleModel) {
        this.title = articleModel.getTitle();
        this.article = articleModel.getArticle();
        this.bannerImage = articleModel.getBannerImage();
        this.createAt = new SimpleDateFormat("dd MMMM yyyy").format(Date.from(articleModel.getCreateAt()
                .atZone(ZoneId.systemDefault()).toInstant()));
        System.out.println(createAt);
    }
}
