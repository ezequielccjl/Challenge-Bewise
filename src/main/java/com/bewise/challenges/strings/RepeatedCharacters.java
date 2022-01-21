package com.bewise.challenges.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
    	System.out.println("Se ejecuta metodo");
    	HashMap<Character,Integer> mapaLetraCantidad = new HashMap<Character,Integer>();
        for (char letra : cadena.toCharArray()) {
            if(mapaLetraCantidad.containsKey(letra)) {
                mapaLetraCantidad.replace(letra, mapaLetraCantidad.get(letra)+1);
            } else if (letra != ' '){
                mapaLetraCantidad.put(letra, 1);
            }
        }
        List<Integer> valuesDelMap = new ArrayList<Integer>();
        mapaLetraCantidad.values().stream().forEach(valor -> valuesDelMap.add(valor));
        int primerValor = valuesDelMap.get(0);
        int contadorDeDiferencias =0;
        int contadorDeIgualdades = 0;
        for (Integer valueActual : valuesDelMap.subList(1, valuesDelMap.size())) {
            if(primerValor+1==valueActual || primerValor-1==valueActual) {
                contadorDeDiferencias++;
            } else if(primerValor==valueActual) {
                contadorDeIgualdades++;
            } else {
                return false;
            }
        }
        if((contadorDeDiferencias==1 && contadorDeIgualdades > 0) || (contadorDeDiferencias==0)) {
            return true;
        } else {
            return false;
        }
    }
}



