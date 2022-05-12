package br.com.arthur.managment.sensediapullrequests.model.dto;

import br.com.arthur.managment.sensediapullrequests.model.entity.PullRequestModal;
import br.com.arthur.managment.sensediapullrequests.util.Convertible;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class PullRequestDto implements Convertible<PullRequestModal> {

    @NotBlank
    private String nome;

    @NotBlank
    private String url;

    private String dateTime;

    public PullRequestDto(PullRequestModal modal) {
        this.nome = modal.getNome();
        this.url = modal.getUrl();
        this.dateTime = DateFormat.getDateInstance(DateFormat.FULL).format(Date.from(modal.getDateTime().atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Override
    public PullRequestModal convert() {
       return new PullRequestModal(this);
    }
}
