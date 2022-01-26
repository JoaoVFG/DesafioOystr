package JoaoVFG.com.github.DesafioOystr.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy' 'hh:mm:ss")
    private Date data;
    private String evento;
    private String texto;
    private String processo;
    private String chaveUnica;

    public Publicacao(Integer id, Date data, String evento, String texto, String processo, String chaveUnica) {
        this.id = id;
        this.data = data;
        this.evento = evento;
        this.texto = texto;
        this.processo = processo;
        this.chaveUnica = chaveUnica;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "id=" + id +
                ", data=" + data +
                ", evento='" + evento + '\'' +
                ", texto='" + texto + '\'' +
                ", processo='" + processo + '\'' +
                ", chaveUnica='" + chaveUnica + '\'' +
                '}';
    }
}
