package br.com.arthur.managment.sensediapullrequests.model.dto;

import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.Date;


@Getter
@Setter
@ToString
public class PullRequestDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String url;

    private String dateTime;

    public PullRequestDto(PullRequestModal dto) {
        this.nome = dto.getNome();
        this.url = dto.getUrl();
        this.dateTime = DateFormat.getDateInstance(DateFormat.FULL).format(Date.from(dto.getDateTime().atZone(ZoneId.systemDefault()).toInstant()));
    }
}
