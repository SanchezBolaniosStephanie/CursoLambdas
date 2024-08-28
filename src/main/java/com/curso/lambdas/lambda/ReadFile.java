package com.curso.lambdas.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) {
        Path url = Paths.get("src/main/java/com/curso/lambdas/streams/anotaciones.txt");

        try(Stream<String> lines = Files.lines(url).onClose(()->{
            System.out.println("Buffer cerrado");
        })){
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
