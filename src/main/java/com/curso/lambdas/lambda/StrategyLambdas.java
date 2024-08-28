package com.curso.lambdas.lambda;

import lombok.*;

import java.util.List;

public class StrategyLambdas {
    public static void main(String[] args) {
        var product1 = Product.builder().id(1L).productName("Galletas")
                .price(20.10).userType("BASIC").build();
        var product2 = Product.builder().id(1L).productName("Galletas")
                .price(20.10).userType("PLUS").build();
        var product3 = Product.builder().id(1L).productName("Galletas")
                .price(20.10).userType("PRIME").build();

        var products = List.of(product2, product1, product3);
        products.forEach(p->{
         switch (p.getUserType()){
             case "BASIC":
                 p.setApplydiscount(Strategies.basicDiscount);
                 break;
             case "PLUS":
                 p.setApplydiscount(Strategies.plusDiscount);
                 break;
             case "PRIME":
                 p.setApplydiscount(Strategies.primeDiscount);
                 break;
         }
        });

        products.forEach(p -> {
            System.out.println("Descuento de "+p.getProductName()+" del usuario "+
                    p.getUserType()+" es: "+p.getApplydiscount().get(p.getPrice()));
        });
    }
}

@FunctionalInterface
interface ApllyDesconuntStrategy{
    double get(Double price);
}

class Strategies{
    static ApllyDesconuntStrategy basicDiscount = p-> p*0.02;
    static ApllyDesconuntStrategy plusDiscount = p-> p*0.05;
    static ApllyDesconuntStrategy primeDiscount = p-> p*0.08;
}

@Data
@ToString
@Builder
class Product{
    private long id;
    private String userType;
    private String productName;
    private double price;
    private ApllyDesconuntStrategy applydiscount;
}
