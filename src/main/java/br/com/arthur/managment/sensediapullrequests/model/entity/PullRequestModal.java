package br.com.arthur.managment.sensediapullrequests.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "service-modal.pr")
@Getter
@Setter
@ToString
public class PullRequestModal implements Serializable {

    private String nome;
    private String url;

}
