package challenge;

import java.util.ArrayList;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
//        throw new UnsupportedOperationException("esse method nao esta implementado ainda");
        if(texto.length() == 0) throw new IllegalArgumentException();
        if(texto == null) throw new NullPointerException();

        String lowerCase = texto.toLowerCase();
        int length = lowerCase.length();
        String output = "";

        for (int i = 0; i < length; i++){
            char insideChar = lowerCase.charAt(i);
            if (insideChar >= '0' && insideChar <= '9'){
                output = output + insideChar;
            } else if (insideChar == ' '){
                output = output + " ";
            } else {
                int ascii = (int) insideChar; // Code from https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java#:~:text=char%20character%20%3D%20'a'%3B,%2F%2F%20ascii%20is%20now%2097.
                int encrypted = ascii + 3;
                output = output + (char) encrypted;
            }
        }
        return output;
    }

    @Override
    public String descriptografar(String texto) {
//        throw new UnsupportedOperationException("esse method nao esta implementado aainda");
        if(texto.length() == 0) throw new IllegalArgumentException();
        if(texto == null) throw new NullPointerException();

        String lowerCase = texto.toLowerCase();
        int length = lowerCase.length();
        String output = "";

        for (int i = 0; i < length; i++){
            char insideChar = lowerCase.charAt(i);
            if (insideChar >= '0' && insideChar <= '9'){
                output = output + insideChar;
            } else if (insideChar == ' '){
                output = output + " ";
            } else {
                int ascii = (int) insideChar;
                int decrypted = ascii - 3;
                output = output + (char) decrypted;
            }
        }
        return output;
    }
}
