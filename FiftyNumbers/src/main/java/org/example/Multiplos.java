package org.example;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Multiplos implements Callable<String> {
    String numero;

    public Multiplos(String n) {
        this.numero=n;
    }

    @Override
    public String call() throws Exception {
        if(Objects.equals(mulTres(numero), "") &&
                Objects.equals(mulTres(numero), "") &&
                Objects.equals(mulTres(numero), "")) return "Sin divisores";

        return ("Divisores: "+ mulTres(numero) + mulCinco(numero)+ mulOnce(numero));
    }

    private String mulTres(String num){
        int suma = 0;
        for(int i = 0; i < num.length()-1; i++){
            suma = suma + num.charAt(i);
        }
        if((suma % 3) == 0)return "(3) ";
        else return "";
    }

    private String mulCinco(String num){
        if((num.charAt(num.length()-1)) == 0 || (num.charAt(num.length()-1)) == 5)return "(5) ";
        else return "";
    }

    private String mulOnce(String num){
        int sumaPar = 0;
        int sumaInpar = 0;
        for(int i = 0; i < num.length()-1; i++){
            if(i%2 == 0)sumaInpar = sumaInpar + num.charAt(i);
            else sumaPar = sumaPar + num.charAt(i);
        }
        if((sumaInpar-sumaPar) % 11 == 0)return "(11)";
        else return "";
    }

}
