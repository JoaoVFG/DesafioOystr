package JoaoVFG.com.github.DesafioOystr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class DesafioOystrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioOystrApplication.class, args);

		//OBS: Só setei a timezone manualmente para a JVM por que o h2-database não tem configuração especifica pra isso
		//Todas as inserções estavam indo com a timezone incorreta
		//Sei que esse tipo de configuração deve ser realizada preferencialmente do lado do Banco
		TimeZone.setDefault(TimeZone.getTimeZone("UTC -3"));
	}

}
