package com.example.urshopmiddleware.product;


import com.example.urshopmiddleware.model.Product;

import java.util.List;


public interface ProductService {
    List<Product> getAll();

    Product getById(int productId);

    List<Product> getByCategory(int productId);

    void add(Product product);

    void update(Product product);

    void delete(int productId);
}
