package com.curso.lambdas.optionals;

import com.curso.lambdas.streams.util.Database;
import com.curso.lambdas.streams.util.Videogame;

import java.util.Optional;

public class OptionalMap {
    public static void main(String[] args) {
        Optional<Videogame> gtaOpt = Optional.of(Database.videogames.get(5));
        String website = gtaOpt.map(v -> "The offical web "+v.getOfficialWebsite()).orElseThrow(() -> new RuntimeException("Video is null"));
        System.out.println(website);
    }
}
