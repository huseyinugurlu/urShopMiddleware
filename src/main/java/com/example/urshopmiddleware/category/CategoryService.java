package com.example.urshopmiddleware.category;


import com.example.urshopmiddleware.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getById(int categoryId);

    void add(Category category);

    void update(Category category);

    void delete(int categoryId);
}
