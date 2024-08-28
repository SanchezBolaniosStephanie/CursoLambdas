package com.curso.lambdas.optionals;

import java.util.Optional;

public class OptionalFlatMap {
    public static void main(String[] args) {
        Movie movie = new Movie("El patito feo", 30.20);

        Optional<Movie> optMovie = Optional.of(movie);

        String movieName = optMovie.flatMap(Movie::getName).get();

        System.out.println(movieName);
    }
}
