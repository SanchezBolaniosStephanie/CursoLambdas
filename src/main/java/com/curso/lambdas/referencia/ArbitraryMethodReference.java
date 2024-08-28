package com.curso.lambdas.referencia;

import java.util.function.BiPredicate;

public class ArbitraryMethodReference {
    public static void main(String[] args) {
        /**
         * Expresion lambda
         */
        //BiPredicate<String, String> compare = (s1,s2) -> s1.equals(s2);

        /**
         * Referencia arbitraria
         * La referencia arbitraria sucede al momento de mandar a llamar
         * a la clase que contiene el método, en este caso la clase String, su nombre
         * deriba del hecho de que no sigue la regla habitual de ser invocado desde el objeto
         * que se instancia, si no mandando a llamar a su clase, esto es posible ya que String deriba
         * de la clase Object
         */
        BiPredicate<String,String> compare = String::equals;

        boolean isEquals = compare.test("a", "b");
        System.out.println(isEquals);

    }
}
