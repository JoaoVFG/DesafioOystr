package JoaoVFG.com.github.DesafioOystr.Service;

import JoaoVFG.com.github.DesafioOystr.DTO.PublicacaoDTO;
import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;
import JoaoVFG.com.github.DesafioOystr.Repository.PublicacaoRepository;
import JoaoVFG.com.github.DesafioOystr.Service.Generator.PublicacaoGeradorChaveUnica;
import JoaoVFG.com.github.DesafioOystr.Service.Util.DataParserUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    @Autowired
    PublicacaoRepository publicacaoRepository;


    @SneakyThrows
    public Publicacao create(PublicacaoDTO publicacaoDTO){


        DataParserUtil dataParserUtil = new DataParserUtil();

        Date date = dataParserUtil.conversorData(publicacaoDTO.getData());

        Publicacao publicacao = new Publicacao();

        publicacao.setId(null);
        publicacao.setData(date);
        publicacao.setProcesso(publicacaoDTO.getProcesso());
        publicacao.setTexto(publicacaoDTO.getTexto());
        publicacao.setEvento(publicacaoDTO.getEvento());


        String chaveUnica = PublicacaoGeradorChaveUnica.getInstance().geradorChaveUnica(publicacao);
        publicacao.setChaveUnica(chaveUnica);

        if(publicacaoRepository.findBychaveUnica(publicacao.getChaveUnica()) == null){

            publicacaoRepository.save(publicacao);

        }else{
            throw new DataIntegrityViolationException("NÃO É POSSIVEL CADASTRAR ESSA PUBLICACAO, POIS ELA JA ESTA CADASTRADA");
        }

        return findById(publicacao.getId());
    }

    public List<Publicacao> findAll(){
        return publicacaoRepository.findAll();
    }

    public Publicacao findById(Integer id){
        Optional<Publicacao> publicacao = publicacaoRepository.findById(id);
        return publicacao.orElseThrow();
    }

    public Publicacao findByChaveUnica(String chaveUnica){
        return publicacaoRepository.findBychaveUnica(chaveUnica);
    }

}
