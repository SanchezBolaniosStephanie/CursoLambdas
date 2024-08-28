package com.curso.lambdas.streams.parallel;

import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PararellStreamTimed {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("inicio "+startTime);
        IntStream.rangeClosed(1,2000000000)
                .parallel()
                .reduce(0, Integer::sum);

        long endTime = System.currentTimeMillis();
        System.out.println("fin "+endTime);
        System.out.println("Total "+ (endTime - startTime));
    }
}
