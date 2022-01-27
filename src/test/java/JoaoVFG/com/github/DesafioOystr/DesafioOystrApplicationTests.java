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

import static junit.framework.TestCase.assertEquals;
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
	public void inicializacaoDeObjetos() {
		publicacaoDTO1 = new PublicacaoDTO("22/12/2022", "0000002-31.2010.5.01.001", "Ut sit amet nisl id leo eleifend dignissim. Curabitur eu pellentesque sem. Mauris quis condimentum tortor. Curabitur augue arcu, fermentum vel luctus et, consectetur laoreet nibh. Fusce volutpat diam at risus ultrices, sit amet aliquet lorem viverra. Morbi id ex sem. Donec varius scelerisque sem a aliquet. Nam tristique accumsan diam, tempor tristique magna sodales vel. Aliquam quis feugiat mi, nec tempus est. Duis metus nibh, pretium ac ullamcorper et, imperdiet ut mi. Nullam nunc purus, congue quis velit eget, scelerisque congue nisl. Mauris id mattis odio. Curabitur eu leo eu velit elementum mattis eget in mauris.","DESPACHO");
		publicacaoDTO2 = new PublicacaoDTO("21/07/2022 17:00:00", "0009902-07.2020.5.10.002","123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123","DESPACHO");
		publicacaoDTO3 = new PublicacaoDTO("24/06/2022 09:51:00", "1236547-06.2013.5.03.005", "TEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTO","DESPACHO");
		publicacaoDTO4 = new PublicacaoDTO("10/01/2022", "0020012-10.2015.5.05.007", "T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3T3ST3","DESPACHO");
		publicacaoDTO5 = new PublicacaoDTO("04/09/2022 04:30:00", "3457894-21.2011.5.06.009","TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%TEXTO!@#$%","DESPACHO");
	}

	@Test
	public void teste01_Insercao() {
		publicacaoService.create(publicacaoDTO1);
		publicacaoService.create(publicacaoDTO2);
		publicacaoService.create(publicacaoDTO3);
		publicacaoService.create(publicacaoDTO4);
		publicacaoService.create(publicacaoDTO5);
	}

	@Test
	public void teste02_PesquisaTodos() {
		List<Publicacao> publicacoes = publicacaoService.findAll();
		assertNotNull(publicacoes);
	}

	@Test
	public void teste03_PesquisaPorChaveUnica() {
		Publicacao publicacao = publicacaoService.findByChaveUnica("B040823F78CFB45FF930B43132B82B71");
		assertNotNull(publicacao);
	}

	@Test
	public void teste04_TentandoInserirPublicacaoJaInserida() {

		Exception exception = assertThrows(DataIntegrityViolationException.class, () -> {
			Publicacao publicacao = publicacaoService.create(publicacaoDTO1);
		});

		String mensagemErro = "NÃO É POSSIVEL CADASTRAR ESSA PUBLICACAO, POIS ELA JA ESTA CADASTRADA";
		String mensagemRecebida = exception.getMessage();

		assertTrue(mensagemRecebida.contains(mensagemErro));

	}

	@Test
	public void teste05_QuantidadeRetornada() {
		List<Publicacao> publicacoes = publicacaoService.findAll();
		assertEquals(publicacoes.size(),5);
	}

	@Test
	public void teste06_CompararConteudoTexto() {
		Publicacao publicacao = publicacaoService.findByChaveUnica("AA20E07053B590D2EED05E8342F0133B");
		assertEquals(publicacao.getTexto(),"TEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTOTEXTO");
	}

	@Test
	public void teste07_ObjetoCriadoComRetornado() {
		PublicacaoDTO publicacaoDTO6 = new PublicacaoDTO("22/12/2022 08:00:00", "0030045-22.2018.2.05.009", "TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123TesteTexto123","DESPACHO");
		Publicacao publicao = publicacaoService.create(publicacaoDTO6);
		Publicacao buscaPublicacao = publicacaoService.findById(6);
		assertEquals(publicao,buscaPublicacao);
	}




}
