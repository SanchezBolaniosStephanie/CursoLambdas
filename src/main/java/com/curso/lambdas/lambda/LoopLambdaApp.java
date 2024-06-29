package com.curso.lambdas.lambda;

import java.util.List;

public class LoopLambdaApp {
    public static void main(String[] args) {
        List<String> countries = List.of("México", "Argentina", "Colombia", "Venezuela", "Chile");

        /**
         * For each
         */
        for(String c : countries){
            System.out.println(c);
        }

        /**
         * For con expresión lambda
         */
        countries.forEach(c -> System.out.println(c.toUpperCase()));
    }
}
