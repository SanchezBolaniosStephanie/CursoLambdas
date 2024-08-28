package com.curso.lambdas.FuntionalInterfaces;


import lombok.ToString;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;


public class ExampleFunction2 {
    static Function<Person, ByteArrayOutputStream> serializer = p ->{
      ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();
      try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(inMemoryBytes)) {
          objectOutputStream.writeObject(p);
          objectOutputStream.flush();
      }catch(IOException e){
          System.out.println(e.getMessage());
      }
      return inMemoryBytes;
    };
    static Function<ByteArrayInputStream, Person> deserializable = bais ->{
        try (ObjectInputStream objectInputStream = new ObjectInputStream(bais)){
            return (Person) objectInputStream.readObject();
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    };
    public static void main(String[] args) {
        ByteArrayOutputStream objtSeriaizable = serializer.apply(new Person("Luis", 30));
        System.out.println("Objeto serializado "+Arrays.toString(objtSeriaizable.toByteArray()));
        Person objtDeserializable = deserializable.apply(new ByteArrayInputStream(objtSeriaizable.toByteArray()));
        System.out.println("Objeto deserializado "+objtDeserializable);
    }
}

/**
 * La clase debe de implementar Serializable para
 * poder hacer uso de los metoso para deserializacion
 */
@ToString
class Person implements Serializable{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
