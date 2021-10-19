package challenge;

import java.util.ArrayList;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
//        throw new UnsupportedOperationException("esse method nao esta implementado aainda");
        if(texto.length() == 0) throw new IllegalArgumentException();
        if(texto == null) throw new NullPointerException();

        String lowerCase = texto.toLowerCase();
        int length = lowerCase.length();
        String resultado = "";

        for (int i = 0; i < length; i++){
            char bagulho = lowerCase.charAt(i);
            if (bagulho >= '0' && bagulho <+ '9'){
                resultado = resultado + bagulho;
            } else if (bagulho == ' '){
                resultado = resultado + " ";
            } else {
                int ascii = (int) bagulho;
                int novoBagulho = ascii + 3;
                resultado = resultado + (char) novoBagulho;
            }
        }
        return resultado;
    }

    @Override
    public String descriptografar(String texto) {
//        throw new UnsupportedOperationException("esse method nao esta implementado aainda");
        if(texto.length() == 0) throw new IllegalArgumentException();
        if(texto == null) throw new NullPointerException();

        String lowerCase = texto.toLowerCase();
        int length = lowerCase.length();
        String resultado = "";

        for (int i = 0; i < length; i++){
            char bagulho = lowerCase.charAt(i);
            if (bagulho >= '0' && bagulho <+ '9'){
                resultado = resultado + bagulho;
            } else if (bagulho == ' '){
                resultado = resultado + " ";
            } else {
                int ascii = (int) bagulho;
                int novoBagulho = ascii - 3;
                resultado = resultado + (char) novoBagulho;
            }
        }
        return resultado;
    }
}
