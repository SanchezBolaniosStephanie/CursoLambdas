package com.curso.lambdas.collectors;

import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorPatitions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        Map<Boolean, List<Videogame>> result = videogames.collect(Collectors.partitioningBy(
                v -> v.getPrice()>15.0
        ));

        result.forEach((k,v) -> System.out.println(k+" - "+v));
    }

}
