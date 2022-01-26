package JoaoVFG.com.github.DesafioOystr.Service.Generator;


import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class PublicacaoUniqueIDGenerator {

    public String geradorChaveUnica(Publicacao publicacao){

        String stringCompleta = geradorString(publicacao);
        MessageDigest md;
        try{
            md = MessageDigest.getInstance("MD5");
        }catch(Exception e){
            return "Erro ao instanciar messageDigest";
        }
        md.update(stringCompleta.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        System.out.println(hash);
        return hash;
    }

    public String geradorString(Publicacao publicacao){
        return publicacao.getData() + publicacao.getEvento() + publicacao.getTexto() + publicacao.getProcesso();
    }
}
