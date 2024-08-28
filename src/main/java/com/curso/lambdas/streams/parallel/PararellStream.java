package com.curso.lambdas.streams.parallel;

import java.util.List;

public class PararellStream {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,34);
        numbers.parallelStream().forEach(n -> System.out.println(n + Thread.currentThread().getName()));
    }
}
