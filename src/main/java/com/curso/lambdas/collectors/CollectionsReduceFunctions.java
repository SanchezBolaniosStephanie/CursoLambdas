package com.curso.lambdas.collectors;

import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsReduceFunctions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //avg(videogames);
       // sum(videogames);
        join(videogames);
    }

    static void avg(Stream<Videogame> stream){
        Double avg = stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println(avg);
    }

    static void sum(Stream<Videogame> stream){
        IntSummaryStatistics summaryStatistics = stream.collect(Collectors.summarizingInt(
                v -> v.getReviews().size()
        ));
        System.out.println("sumatoria: "+summaryStatistics.getSum());
        System.out.println("maximo: "+summaryStatistics.getMax());
        System.out.println("minimo: "+summaryStatistics.getMin());
        System.out.println("promedio: "+summaryStatistics.getAverage());
    }

    static  void join(Stream<Videogame> stream){
        String union = stream
                .map(Videogame::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(union);
    }
}
