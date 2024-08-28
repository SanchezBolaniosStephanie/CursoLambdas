package com.curso.lambdas.validator;

import com.curso.lambdas.streams.util.Database;

public class ValidatorApp {
    public static void main(String[] args) {
        var videogame1 = Database.videogames.get(0);
        var videogame2 = Database.videogames.get(1);
        var videogame3 = Database.videogames.get(2);
        var videogame4 = Database.videogames.get(4);

        Validator.applyRules(Rules.rules, videogame4);
        System.out.println("Videogame valid");
    }
}
