package com.curso.lambdas.collectors;

import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Videogame;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToCollections {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //System.out.println(streamToCollection(videogames,"LIST"));
        streamToMapStream(videogames).forEach((k,v) -> System.out.println(k+" - "+v));
    }

    static Collection<Videogame> streamToCollection(Stream<Videogame> stream, String type){
        return (type.equals("LIST"))?stream.collect(Collectors.toList()):stream.collect(Collectors.toSet());
    }

    static Map<String, Double> streamToMapStream(Stream<Videogame> stream){
        return stream
                .distinct()
                .collect(Collectors.toMap(Videogame::getName, Videogame::getPrice));
    }
}
