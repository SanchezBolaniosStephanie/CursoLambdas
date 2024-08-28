package com.curso.lambdas.streams;

import com.curso.lambdas.streams.util.Console;
import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Review;
import com.curso.lambdas.streams.util.Videogame;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciseLambdas {

    public static void main(String[] args){
        Stream<Videogame> videogames = Database.videogames.stream();
        /*boolean e1 = exercise1(videogames);
        System.out.println("Exercise 1: "+e1);
        System.out.println("-------------------------------");*/
        /*Stream<String> e2 = exercise2(videogames);
        System.out.println("Exercise 2: ");
        e2.forEach(System.out::println);
        System.out.println("-------------------------------");*/
        /*Videogame e3 = exercise3(videogames);
        System.out.println("Exercise 3: "+e3.toString());
        System.out.println("-------------------------------");*/
        /*Stream<String> e4 = exercise4(videogames);
        System.out.println("Exercise 4: ");
        e4.forEach(System.out::println);
        System.out.println("-------------------------------");*/
        Stream<Double> e5 = exercise5(videogames);
        System.out.println("Exercise 5: ");
        e5.forEach(System.out::println);
        System.out.println("-------------------------------");



    }
    /**
     * Regresar true si el stream contiene al menos un videojuego con números
     * de ventas mayor a 10 y no este en descuento o su precio sea mayor a 9.99
     * de lo contrario regresar false
     */

    static  Boolean exercise1(Stream<Videogame> stream){
        return stream
                .anyMatch(v -> v.getPrice()>10 && (!v.getIsDiscount() || v.getPrice()>9.99));
    }

    /**
     * Regresar un stream unicamente con  los titulos de todas las consolas
     * que sea de XBOX durante el proceso imprimir los resultados
     * ignorando los repetidos
     *
     */
    static Stream<String> exercise2(Stream<Videogame> stream){
        return stream
                .filter(v -> v.getConsole().equals(Console.XBOX))
                .map(Videogame::getName)
                .distinct()
                //.peek(System.out::println)
                ;
    }

    /**
     * Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los sprimeros 10 elementos del stream
     */
    static Videogame exercise3(Stream<Videogame> stream){
        return stream
                .limit(10)
                .max(Comparator.comparingInt(Videogame::getTotalSold))
                .orElseThrow(NoSuchElementException::new);

    }

    /**
     * Regresar un stream con todos los comentarios de cada review de todos los videojuegos del stream
     *
     */
    static Stream<String> exercise4(Stream<Videogame> stream){
        return stream
                .flatMap(v -> v.getReviews().stream().map(Review::getReview));
    }

    /**
     * Regresar un stream con todos los videojuegos con precios menores a 20.0
     * sin utilizar el operador filter()
     */
    static Stream<Double> exercise5(Stream<Videogame> stream){
        return stream
               .sorted(Comparator.comparingDouble(Videogame::getPrice))
                .takeWhile(v -> v.getPrice()<20.0)
                .map(Videogame::getPrice)
                ;
    }
}
