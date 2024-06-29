package com.curso.lambdas.lambda;

public class LambdaApp {

    public static void main (String[] args){
        /**
         * Uso de la interfaz funcional mediante el uso de clase anonima
         */
        Math substract = new Math() {
            @Override
            public Double excetue(Double a, Double b) {
                return a-b;
            }
        };

        System.out.println("Uso de clase anonima: \n"+substract.excetue(15.20, 9.80));

        /**
         * Uso de la interfaz funcional mediante expersión Lambda
         * Inferencia de parametros
         * Al tener el proceso en una línea no es necesario utilizar la palabra return,
         * ya que no se encuentra delimitado en un bloque
         */
        Math multiply = (a,b) -> a*b;
        System.out.println("Expresion lamba multiply: \n"+multiply.excetue(23.00,2.2));
        /**
         * Sin inferencia de parametros
         * ES necesario especificar la palabra return, ya que se hace uso
         * de un bloque de código
         */
        Math divide = (Double a, Double b) -> {
          System.out.println("Se inicia división");
          return a/b;
        };
        System.out.println("Uso de expresion lambda divide: \n"+ divide.excetue(52.00, 3.19));

        /**
         * El uso de los métodos defualt de la interfaz, se puede mandar a llamar desde cualquier
         * implementación anterior
         */
        System.out.println("Invocación de método suma default de la interfaz: \n"+multiply.sum(13.2,16.17));
    }
}
