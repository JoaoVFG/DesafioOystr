package JoaoVFG.com.github.DesafioOystr.Service;

import JoaoVFG.com.github.DesafioOystr.DTO.PublicacaoDTO;
import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;
import JoaoVFG.com.github.DesafioOystr.Repository.PublicacaoRepository;
import JoaoVFG.com.github.DesafioOystr.Service.Util.DataParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    @Autowired
    PublicacaoRepository publicacaoRepository;


    public Publicacao create(PublicacaoDTO publicacaoDTO) throws ParseException {

        DataParserUtil dataParserUtil = new DataParserUtil();

        Date date = dataParserUtil.conversorData(publicacaoDTO.getData());


        Publicacao publicacao = new Publicacao();
        publicacao.setId(null);
        publicacao.setChaveUnica(null);
        publicacao.setData(date);
        publicacao.setProcesso(publicacaoDTO.getProcesso());
        publicacao.setTexto(publicacaoDTO.getTexto());
        publicacao.setEvento(publicacaoDTO.getEvento());


        publicacaoRepository.save(publicacao);

        return findById(publicacao.getId());
    }

    public List<Publicacao> findAll(){
        return publicacaoRepository.findAll();
    }

    public Publicacao findById(Integer id){
        Optional<Publicacao> publicacao = publicacaoRepository.findById(id);
        return publicacao.orElseThrow();
    }
}
