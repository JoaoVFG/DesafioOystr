package JoaoVFG.com.github.DesafioOystr.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy' 'HH:mm:ss")
    private Date data;

    private String evento;

    @Column(length = 2500)
    private String texto;

    private String processo;

    @Column(length = 2500)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacao that = (Publicacao) o;
        return id.equals(that.id) && data.equals(that.data) && evento.equals(that.evento) && texto.equals(that.texto) && processo.equals(that.processo) && chaveUnica.equals(that.chaveUnica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, evento, texto, processo, chaveUnica);
    }
}
