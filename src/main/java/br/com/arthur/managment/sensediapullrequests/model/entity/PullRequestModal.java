package br.com.arthur.managment.sensediapullrequests.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "service-modal.pr")
@Getter
@Setter
@ToString
public class PullRequestModal {

    private String nome;
    private String url;

}
