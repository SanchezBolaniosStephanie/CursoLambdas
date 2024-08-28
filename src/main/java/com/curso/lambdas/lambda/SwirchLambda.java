package com.curso.lambdas.lambda;

public class SwirchLambda {
    public static void main(String[] args) {
        var result = switch ("UNO"){
            case "UNO" -> 1;
            case "DOS" ->2;
            default -> 0;
        };
        System.out.println(result);
    }
}
