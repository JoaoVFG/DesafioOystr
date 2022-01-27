package JoaoVFG.com.github.DesafioOystr.Resources;

import JoaoVFG.com.github.DesafioOystr.DTO.PublicacaoDTO;
import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;
import JoaoVFG.com.github.DesafioOystr.Service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/publicacao")
public class PublicacaoResource {

    @Autowired
    PublicacaoService publicacaoService;

    @RequestMapping(value = "/buscaPublicacao", method = RequestMethod.GET)
    public ResponseEntity<List<Publicacao>> findAll(){
        List<Publicacao> publicacoes = publicacaoService.findAll();
        return ResponseEntity.ok().body(publicacoes);
    }

    @RequestMapping(value = "/insere", method = RequestMethod.POST)
    public ResponseEntity<Publicacao> createPublicacao(@RequestBody PublicacaoDTO publicacaoDTO){
        Publicacao novaPublicacao = publicacaoService.create(publicacaoDTO);
        return ResponseEntity.ok().body(novaPublicacao);
    }
}
