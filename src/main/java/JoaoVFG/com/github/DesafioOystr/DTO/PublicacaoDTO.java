package JoaoVFG.com.github.DesafioOystr.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicacaoDTO {

    private String data;
    private String evento;
    private String texto;
    private String processo;

    public PublicacaoDTO(String date, String evento, String texto, String processo) {
        this.data = date;
        this.evento = evento;
        this.texto = texto;
        this.processo = processo;
    }

    @Override
    public String toString() {
        return "PublicacaoDTO{" +
                "date='" + data + '\'' +
                ", evento='" + evento + '\'' +
                ", texto='" + texto + '\'' +
                ", processo='" + processo + '\'' +
                '}';
    }
}
