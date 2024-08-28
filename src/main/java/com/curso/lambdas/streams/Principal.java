package com.curso.lambdas.streams;

import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator2;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        validate("ana");

    }
    static void validate(String palabra){
        boolean flag = false;
        String palabraAiux = "";
        String palabra2 = palabra.replace(" ", "");
        Stream<Character> characters = null;
        int tam= palabra2.length();

        palabraAiux = IntStream.range(0,tam)
                        .mapToObj(b -> String.valueOf((char) palabra2.charAt(b)))
                        .reduce((a,b) -> b.concat(a))
                        .orElse("");

        if (palabra2.equalsIgnoreCase(palabraAiux))
            System.out.println("Desde validate con stream: es palindromo");
        else
            System.out.println("Desde validate con stream: no es palindromo");

    }

    static void validate2(String palabara){
        String palabra2 = palabara.replace(" ","");
        String palabraAux = "";
        for (int i = palabra2.length()-1; i >=0 ; i--) {
            palabraAux += palabra2.charAt(i);
        }
        if (palabra2.equalsIgnoreCase(palabraAux))
            System.out.println("Desde validate 2 sin stream: es palindromo");
        else
            System.out.println("Desde validate 2 sin stream: no es palindromo");
    }


        /*palabra2.chars()
                .mapToObj(e -> String.valueOf((char)e)) //convierte cada letra a String
                .reduce((a, e)-> e.concat(a)) //concadena todo pero con el orden contrario
                .ifPresent(System.out::println);*/
}

