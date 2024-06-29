package com.curso.lambdas.interfaz;

import java.util.List;

public interface IDataService <T>{
    T getById(Long id);
    List<T> getAllRecords();
}
