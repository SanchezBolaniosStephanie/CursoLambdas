package com.curso.lambdas.FuntionalInterfaces;

import java.util.function.Function;

public class ExampleFunction1 {
    /**
     * La interfaz Function se utiliza para realizar operaciones con objetos
     */
    static Function<Integer, Integer> sum = n -> n + 10;
    static Function<Integer, Integer> mult = n -> n * 10;
    static Function<Integer, Integer> andThenM = mult.andThen(sum);
    static Function<Integer, Integer> composeM = mult.compose(sum);
    public static void main(String[] args) {
        System.out.println(sum.apply(5));
        System.out.println(mult.apply(5));

        System.out.println(andThenM.apply(5));
        System.out.println(composeM.apply(5));

    }
}
