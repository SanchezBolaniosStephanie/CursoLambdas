package com.curso.lambdas.interfaz;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FundamentalApp {

    public static void main (String[] args){
        EmployeeDataServiceImpl employeeImpl = new EmployeeDataServiceImpl();
        Employee employee = employeeImpl.getById(12345678910L);
        System.out.println("Prueba interfaces empleado implementación: \n"+
                employee.getDni()+"\n"+
                employee.getName()+"\n"+
                employee.getSalary());

        /**
         * Clase anonima, la clase no esta implementando la interfaz
         * si no que crea una instancia
         */
        IDataService<String> anonima = new IDataService<String>() {
            @Override
            public String getById(Long id) {
                return "";
            }

            @Override
            public List<String> getAllRecords() {
                return Collections.emptyList();
            }
        };
    }
}
