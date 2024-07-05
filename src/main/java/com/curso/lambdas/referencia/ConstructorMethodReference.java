package com.curso.lambdas.referencia;

import lombok.ToString;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {
        /**
         * Expresión lambda
         */
        //Supplier<MyObject> obj = () -> new MyObject();
        /**
         * Referencia al constructor
         */
        Supplier<MyObject> obj = MyObject::new;
        System.out.println(obj.get());

    }
}


@ToString
class MyObject{
    private String text;
    private Integer num;

    public MyObject(){
        this.text = UUID.randomUUID().toString();
        this.num = new Random().nextInt(1000);
    }
}
