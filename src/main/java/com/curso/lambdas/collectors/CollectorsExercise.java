package com.curso.lambdas.collectors;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.curso.lambdas.streams.util.Console;
import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Review;
import com.curso.lambdas.streams.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExercise {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //getReviews(videogames).forEach(System.out::println);
        getWebSites(videogames).forEach((v,k) -> System.out.println(v+" - "+k));
       // getConsolesPricesAvg(videogames).forEach((v,k) -> System.out.println(v+" - "+k));
    }

    /**
     * Regresar una lista inmutable con todos los revies del stream
     *
     */
    static List<Review> getReviews(Stream<Videogame> stream){
        return stream
                .flatMap(v -> v.getReviews().stream())
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Regresar un mapa true con todos los videojuegos que tengan una url(website)
     * con una longitud menor a 15 de lo contrario regresar falase con una lista
     * de los videojuegos que no cumplan la condicion
     */

    static Map<Boolean, List<Videogame>> getWebSites(Stream<Videogame> stream){
     return
    stream.collect(
            Collectors.partitioningBy(v -> v.getOfficialWebsite().length() > 15)
    );

    }

    /**
     * Regresar un mapa del promedio de ventas todas las consolas
     * la clave del mapa sera la consola y el valor el promedio
     */
    static Map<Console, Double> getConsolesPricesAvg(Stream<Videogame> stream){
        return stream.collect(Collectors.groupingBy(Videogame::getConsole,
                Collectors.averagingDouble(Videogame::getTotalSold))
        );
    }
}
