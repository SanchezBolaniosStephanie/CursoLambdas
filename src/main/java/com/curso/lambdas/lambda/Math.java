package com.curso.lambdas.lambda;

@FunctionalInterface
public interface Math {
    /**
     * Método abstracto
     */
    Double excetue (Double a, Double b);

    /**
     * Método por default
     */
    default Double sum (Double a, Double b){ return a + b;}
}
