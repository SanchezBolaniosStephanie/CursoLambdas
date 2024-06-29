package com.curso.lambdas.interfaz;

import java.util.Collections;
import java.util.List;

public class ProductDataServiceImpl implements IDataService<Product>{

    @Override
    public Product getById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Donas");
        product.setPrice(10.50);
        return product;
    }

    @Override
    public List<Product> getAllRecords() {
        return Collections.emptyList();
    }
}
