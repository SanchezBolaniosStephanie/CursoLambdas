package com.curso.lambdas.optionals;

import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Videogame;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<Videogame> gtaOpt = Optional.ofNullable(null);
        System.out.println(gtaOpt.orElseThrow(() -> new RuntimeException("Video is null")));
    }
}
