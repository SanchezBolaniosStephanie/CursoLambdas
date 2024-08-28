package com.curso.lambdas.referencia;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.Supplier;

public class StaticMethodReference {

    public static void main(String[] args) {
        /**
         * SUpplier es una interfaz definida de Java, congtiene un solo metogo estatico get()
         * que no recibe parametros
         */
        /**
         * EXpresión lambda
         */
        //Supplier<UUID> getToken = () -> UUID.randomUUID();
        /**
         * Referencia a metodo estatico, el método estatico pertence a una clase
         * el método no puede ser modificado, solo cumple su funcion
         */
        Supplier<UUID> getToken =UUID::randomUUID;
        System.out.println("Token aleatorio "+getToken.get());

    }
}
