package br.com.arthur.managment.sensediapullrequests.model.entity;

import br.com.arthur.managment.sensediapullrequests.model.dto.PullRequestDto;
import br.com.arthur.managment.sensediapullrequests.util.Convertible;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Document(collection = "service-modal.pr")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PullRequestModal implements Convertible<PullRequestDto> {

    @NotBlank
    private String nome;

    @NotBlank
    private String url;

    private LocalDateTime dateTime;

    public PullRequestModal(PullRequestDto pullRequestDto) {
        this.nome = pullRequestDto.getNome();
        this.url = pullRequestDto.getUrl();
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public PullRequestDto convert() {
        return new PullRequestDto(this);
    }
}
