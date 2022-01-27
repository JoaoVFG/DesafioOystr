package JoaoVFG.com.github.DesafioOystr;

import JoaoVFG.com.github.DesafioOystr.DTO.PublicacaoDTO;
import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;
import JoaoVFG.com.github.DesafioOystr.Service.PublicacaoService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesafioOystrApplicationTests {

	@Autowired
	PublicacaoService publicacaoService;

	PublicacaoDTO publicacaoDTO1;
	PublicacaoDTO publicacaoDTO2;
	PublicacaoDTO publicacaoDTO3;
	PublicacaoDTO publicacaoDTO4;
	PublicacaoDTO publicacaoDTO5;



	@Before
	public void inicializacaoDeObjetos(){
		publicacaoDTO1 = new PublicacaoDTO("22/12/2022", "0000002-31.2010.5.01.001", "Ut sit amet nisl id leo eleifend dignissim. Curabitur eu pellentesque sem. Mauris quis condimentum tortor. Curabitur augue arcu, fermentum vel luctus et, consectetur laoreet nibh. Fusce volutpat diam at risus ultrices, sit amet aliquet lorem viverra. Morbi id ex sem. Donec varius scelerisque sem a aliquet. Nam tristique accumsan diam, tempor tristique magna sodales vel. Aliquam quis feugiat mi, nec tempus est. Duis metus nibh, pretium ac ullamcorper et, imperdiet ut mi. Nullam nunc purus, congue quis velit eget, scelerisque congue nisl. Mauris id mattis odio. Curabitur eu leo eu velit elementum mattis eget in mauris.","DESPACHO");
		publicacaoDTO2 = new PublicacaoDTO("21/07/2022 17:00:00", "0000002-31.2010.5.01.001","123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123","DESPACHO");
		publicacaoDTO3 = new PublicacaoDTO("24/06/2022 09:51:00", "0000002-31.2010.5.01.001", "TEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTO","DESPACHO");
		publicacaoDTO4 = new PublicacaoDTO("10/01/2022", "0000002-31.2010.5.01.001", "T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3","DESPACHO");
		publicacaoDTO5 = new PublicacaoDTO("04/09/2022 04:30:00", "0000002-31.2010.5.01.001","TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%","DESPACHO");
	}

	@Test
	public void teste01_Insercao(){
		publicacaoService.create(publicacaoDTO1);
		publicacaoService.create(publicacaoDTO2);
		publicacaoService.create(publicacaoDTO3);
		publicacaoService.create(publicacaoDTO4);
		publicacaoService.create(publicacaoDTO5);
	}

	@Test
	public void teste02_PesquisaTodos(){
		List<Publicacao> publicacoes = publicacaoService.findAll();
		assertNotNull(publicacoes);
	}

	@Test
	public void teste03_PesquisaPorChaveUnica(){
		Publicacao publicacao = publicacaoService.findByChaveUnica("DACE6EEB5723A14EF1B0165430CDAFA8");
		assertNotNull(publicacao);
	}

	@Test
	public void teste04_TentandoInserirPublicacaoJaInserida(){

		Exception exception = assertThrows(DataIntegrityViolationException.class, () ->{
			Publicacao publicacao = publicacaoService.create(publicacaoDTO1);
		});

		String mensagemErro = "NÃO É POSSIVEL CADASTRAR ESSA PUBLICACAO, POIS ELA JA ESTA CADASTRADA";
		String mensagemRecebida = exception.getMessage();

		assertTrue(mensagemRecebida.contains(mensagemErro));

	}






}
