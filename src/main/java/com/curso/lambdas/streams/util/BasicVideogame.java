package com.curso.lambdas.streams.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicVideogame {
    private String name;
    private Double proce;
    private Console console;
}
