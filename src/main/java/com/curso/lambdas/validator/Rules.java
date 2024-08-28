package com.curso.lambdas.validator;

import com.curso.lambdas.streams.util.Console;
import com.curso.lambdas.streams.util.Videogame;

import java.util.List;
import java.util.Objects;

public class Rules {

    private Rules(){}


    private final static Validator<Videogame, RuntimeException> isNull = videogame -> {
        if(Objects.isNull(videogame)) throw new IllegalArgumentException("cant be null");
    };

    private final static Validator<Videogame, RuntimeException> validPrice = videogame -> {
        if(videogame.getPrice() < 20.0) throw new IllegalArgumentException("Price must be grater than 20.00");
    };

    private final static Validator<Videogame, RuntimeException> validConsole = videogame -> {
        if(!videogame.getConsole().equals(Console.XBOX)) throw new IllegalArgumentException("Videograme must be for XBOX");
    };

    private final static Validator<Videogame, RuntimeException> validTotalSold = videogame -> {
        if(videogame.getTotalSold()<10) throw new IllegalArgumentException("Total sold must be grater than 10");
    };



    public static List<Validator<Videogame, RuntimeException>> rules =List.of(isNull, validPrice, validConsole,validTotalSold);
}
