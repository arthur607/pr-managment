package br.com.arthur.managment.sensediapullrequests.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Document(collection = "service-modal.pr")
@Getter
@Setter
@ToString
public class PullRequestModal {

    @NotBlank
    private String nome;

    @NotBlank
    private String url;

    private LocalDateTime dateTime;

}
