package com.curso.lambdas.lambda;

import com.curso.lambdas.interfaz.Product;

public class GenericApp {

    public static void main(String[] args) {
        /**
         * No es necesario encerrar entre parentesis el argumento,
         * ya que en este caso solo es uno
         */
        Generic<String> printString = string -> System.out.println(string);
        printString.print("Hola mundo");

        Generic<Product> product = stringP -> System.out.println(stringP);
        product.print(new Product());
    }
}
