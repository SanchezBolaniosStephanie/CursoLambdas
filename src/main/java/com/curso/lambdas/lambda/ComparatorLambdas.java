package com.curso.lambdas.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdas {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,47,78,9,12);
        number.sort((a,b) -> a-b);
        System.out.println(number);


        List<String> names = Arrays.asList("LISA","Mark","Lalo");
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        names.sort(Comparator.reverseOrder());
        System.out.println(names);

        List<Person> persons = Arrays.asList(new Person("Maria",54),
                new Person("Luna",12),
                new Person("Mariana",34),
                new Person("Alexia",34));
        persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(persons);
    }
}

@Data
@AllArgsConstructor
class Person{
    private String name;
    private Integer age;
}
