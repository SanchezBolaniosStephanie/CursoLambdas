package com.curso.lambdas.FuntionalInterfaces;


import java.util.*;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list= List.of(6,2,4,6,3,1,3,7,8,9);
        /**
         * primera parte con stream
         */
        //Eliminar los repetidos
        System.out.println("Eliminar elementos repetidos");
        List<Integer> list2 = list.stream().
                distinct().
                sorted().
                toList();
        //Elevar al cuadrado todos los numeros
        System.out.println("Cuadrado de todos los numero");
        List<Integer> list3 = list.stream()
                .map(i -> i*i)
                .toList();

        //Obtener los numero pares
        System.out.println("Numero pares");
        list.stream().filter(x -> x%2 ==0).forEach(num -> System.out.println(num));

        //regresar una lista ordenada
        System.out.println("Lista ordenada");
        list.stream().sorted().forEach(num -> System.out.println(num));

        /**
         * Segunda parte sin stream
         */
        System.out.println("Elevar al cuadrado");
        List<Integer> listcdr = new ArrayList<Integer>();
        for (int i=0; i<= list.size()-1;i++){
            int aux= list.get(i) * list.get(i);
            listcdr.add(aux);
        }
        System.out.println(listcdr);

        //Obtener los numero pares
        System.out.println("Numero pares");
        List<Integer> listarmv = new ArrayList<Integer>(list);
        listarmv.removeIf(n -> n%2 !=0);
        System.out.println(listarmv);

        //regresar una lista ordenada
        List<Integer> listaord = new ArrayList<Integer>(list);


    }
}
