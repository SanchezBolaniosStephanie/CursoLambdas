package com.curso.lambdas.referencia;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ObjectMetodReference {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);
        /**
         * Los streams actuan como un encapsulador de objetos,
         * con los cuales se puede trabajar de manera masiva,
         * rapidamente
         */
        /**
         * Se crearon Streams especificos para los datos de tipo
         * Long Integer y Double, aunque los stream manejen datos genericos,
         * no aceptaban recibir parametros de tipo numericos, por lo que se
         * empleo el uso de streams especificos para estos datos
         */
        IntStream repeat = IntStream.range(1,11);
        /**
         * expresión lambda
         */
        //repeat.forEach(i->numbers.add(i));
        /**
         * referencia a metodo por objeto
         */
        repeat.forEach(numbers::add);
        System.out.println(numbers);
    }
}
