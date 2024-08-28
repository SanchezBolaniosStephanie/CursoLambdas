package com.curso.lambdas.FuntionalInterfaces;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExercise {
    static Predicate<Integer> isGreaterThan100 = n -> n > 100;
    static Predicate<Integer> isLessThan10 = n -> n < 10;
    static Predicate<Integer> isBetween10And100 = isGreaterThan100.and(isLessThan10);
    static Predicate<Integer> isBetween10Or100 = isGreaterThan100.or(isLessThan10);
    static BiPredicate<String, String> myEquals = (s1, s2) -> "HelloWorld".equals(s1.concat(s2));
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,20,300,15));
        lista.removeIf(isBetween10Or100.negate());
        System.out.println(lista);
        System.out.println(myEquals.test("Hello", "World"));
    }
}
