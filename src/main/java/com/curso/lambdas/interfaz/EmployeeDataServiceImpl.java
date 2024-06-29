package com.curso.lambdas.interfaz;

import java.util.List;

public class EmployeeDataServiceImpl implements IDataService<Employee>{

    @Override
    public Employee getById(Long id){
        Employee employee = new Employee();
        employee.setDni(id);
        employee.setName("Pedro Pe");
        employee.setSalary("49000.00");
        return employee;
    }
    @Override
    public List<Employee> getAllRecords(){
        return null;
    }
}
