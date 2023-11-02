package com.example.urshopmiddleware.controller.category;


import com.example.urshopmiddleware.category.CategoryService;
import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.controller.BaseController;
import com.example.urshopmiddleware.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.CATEGORIES)
public class CategoryController extends BaseController implements CategoryControllerApi {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(ApiConstants.GET_ALL)
    public ResponseEntity<?> getAllCategory() {
        final List<Category> data = categoryService.getAll();
        return success(data);
    }

    @GetMapping(ApiConstants.BY_ID)
    public ResponseEntity<?> getByIdCategory(@PathVariable int id) {
        final Category data = categoryService.getById(id);
        return success(data);
    }

    @PostMapping(ApiConstants.ADD)
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        final Category category = Category.builder()
                .categoryName(createCategoryRequest.name())
                .productIds(null)
                .build();
        this.categoryService.add(category);
    }

    @PutMapping(ApiConstants.UPDATE + ApiConstants.BY_ID)
    public void update(@PathVariable int id, @RequestBody final UpdateCategoryRequest updateCategoryRequest) {
        Category category = Category.builder()
                .categoryId(id)
                .categoryName(updateCategoryRequest.name())
                .build();
        this.categoryService.update(category);
    }

    @DeleteMapping(ApiConstants.BY_ID)
    public void delete(@PathVariable int id) {
        this.categoryService.delete(id);
    }


}