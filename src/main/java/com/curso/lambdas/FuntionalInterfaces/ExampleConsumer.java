package com.curso.lambdas.FuntionalInterfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleConsumer {
    public static void main(String[] args) {
        Set<Integer> num = Set.of(1,2,3);
        List<Integer> square = new LinkedList<>();
        num.forEach(n -> square.add(n*n));
        System.out.println(square);

        /**
         * BiConsumer
         */
        Map<Boolean, String> map = Map.of(true, "Es verdadero", false, "es falso");
        map.forEach((k,v) -> System.out.println(k+"-"+v));
    }
}
