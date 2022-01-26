package JoaoVFG.com.github.DesafioOystr.Service.Util;

import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class DataParserUtil {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy' 'hh:mm:ss");

    public Date conversorData(String dataString) throws ParseException{
        Date dataConvertida;
        System.out.println(dataString);

        if(verificaTamanho(dataString)) dataString = insereHoraData(dataString);

        System.out.println(dataString);

        try {
            dataConvertida = formatter.parse(dataString);
        } catch (ParseException e) {
            throw new ParseException("Erro ao Converter a data", e.getErrorOffset());
        }
        return dataConvertida;
    }

    private Boolean verificaTamanho(String data){
        System.out.println(data.length());
        return data.length() == 10;
    }

    private String insereHoraData(String data){
        return data + " 00:00:00";
    }
}
