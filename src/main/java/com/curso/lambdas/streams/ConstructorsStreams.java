package com.curso.lambdas.streams;

import com.curso.lambdas.streams.util.BasicVideogame;
import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Review;
import com.curso.lambdas.streams.util.Videogame;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorsStreams {
    public static void main(String[] args) {
        Stream<Videogame> streamGame = Database.videogames.stream();



    /**
     * ---------------------Métodos finales--------------------
     */
    //countOperator(streamGame);
        //streamGame.forEach(System.out::println);
        /**
         * operadores match
         */
        //anyMatchOperator(streamGame);
        //allMatchOperator(streamGame);
        //noneMatchOperator(streamGame);

        /**
         * Busquedas en stream
         */
        //finFirstOperator(streamGame);
        //findAnyOperator(streamGame);

        /**
         * acumuladores
         */
       // reduceOperator(streamGame);

        /**
         * MAX Y MIN
         */
        //maxOperator(streamGame);
        //minOperator(streamGame);

        /**
         * ---------------------Métodos intermedios--------------------
         */

        //limitOperator(streamGame);
        //skipOperator(streamGame);


        //filterOperator(streamGame);

        //mapOperator(streamGame);

        //flatMapOperator(streamGame);
        //sortOperator(streamGame);

        //takeWhileOperator(streamGame);
        dropWhileOperator(streamGame);

    }

    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count());
    }

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean result = stream.anyMatch(video -> video.getTotalSold() > 1);
        System.out.println(result);
    }

    static void allMatchOperator(Stream<Videogame> stream){
        boolean result = stream.allMatch(video -> video.getTotalSold() > 150);
        System.out.println(result);
    }

    static void noneMatchOperator(Stream<Videogame> stream){
        boolean result = stream.noneMatch(video -> video.getReviews().isEmpty());
        System.out.println(result);
    }

    static void finFirstOperator(Stream<Videogame> stream){
        Optional<Videogame> result = stream.findFirst();
        System.out.println(result);
    }

    static void findAnyOperator(Stream<Videogame> stream){
        Optional<Videogame> result = stream.findAny();
        System.out.println(result);
    }

    static void reduceOperator(Stream<Videogame> stream){
        Optional<Integer> result = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        System.out.println(result);
    }


    static void maxOperator(Stream<Videogame> stream){
        Optional<Videogame> result = stream.max((a,b) -> a.getName().compareTo(b.getName()));
        System.out.println(result);
    }

    static void minOperator(Stream<Videogame> stream){
        Optional<Videogame> result = stream.min((a,b) -> a.getName().compareTo(b.getName()));
        System.out.println(result);
    }

    static void distincOperator(Stream<Videogame> stream){
        System.out.println(stream.distinct().count());
    }

    static void limitOperator(Stream<Videogame> stream){
        List<Videogame> videogames = stream.limit(5).collect(Collectors.toList());
        videogames.forEach(System.out::println);
    }

    static void skipOperator(Stream<Videogame> stream){
        List<Videogame> videogames = stream.skip(15).collect(Collectors.toList());
        videogames.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream){
        List<Videogame> videogames = stream
                .filter(v -> v.getPrice() > 12.0)
                .filter(v-> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());

        videogames.forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> stream){
        List<BasicVideogame> videogames = stream
                .map(v -> {
                    return BasicVideogame.builder().name(v.getName()).proce(v.getPrice()).console(v.getConsole()).build();
                })
                .collect(Collectors.toList());

        List<String> titles = videogames.stream().map(BasicVideogame::getName).collect(Collectors.toList());

        videogames.forEach(System.out::println);
        System.out.println("-------------");
        titles.forEach(System.out::println);
    }


    static void flatMapOperator(Stream<Videogame> stream){
        List<Review> videogames = stream
                .flatMap(v -> v.getReviews().stream())
                .collect(Collectors.toList());

        System.out.println(videogames);
    }
    static void sortOperator(Stream<Videogame> stream){
        List<Videogame> videogamesSorted = stream
                .sorted(Comparator.comparingInt(v -> v.getReviews().size()))
                .collect(Collectors.toList());

        videogamesSorted.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> stream){
        /**
         * se recomienda oredenar primero
         */
        List<Videogame> videos = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());

        videos.forEach(System.out::println);


    }

    static void takeWhileOperator(Stream<Videogame> stream){
        /**
         * se recomienda oredenar primero
         */
        List<Videogame> videos = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        videos.forEach(System.out::println);

    }
}
