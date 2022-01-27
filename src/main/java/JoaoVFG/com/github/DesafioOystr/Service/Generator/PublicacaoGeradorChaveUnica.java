package JoaoVFG.com.github.DesafioOystr.Service.Generator;


import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class PublicacaoGeradorChaveUnica {

    private final static PublicacaoGeradorChaveUnica publicacaoGeradorChaveUnica = new PublicacaoGeradorChaveUnica();

    private PublicacaoGeradorChaveUnica(){

    }

    public static PublicacaoGeradorChaveUnica getInstance(){
        return publicacaoGeradorChaveUnica;
    }


    public String geradorChaveUnica(Publicacao publicacao) {

        String stringCompleta = geradorString(publicacao);
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            return "Erro ao instanciar messageDigest";
        }
        md.update(stringCompleta.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public String geradorString(Publicacao publicacao) {
        return publicacao.getData() + publicacao.getEvento() + publicacao.getTexto() + publicacao.getProcesso();
    }
}
