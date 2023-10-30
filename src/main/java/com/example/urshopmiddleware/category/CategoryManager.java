package com.example.urshopmiddleware.category;

import com.example.urshopmiddleware.client.UrShopClient;
import com.example.urshopmiddleware.client.category.CreateCategoryClientRequest;
import com.example.urshopmiddleware.client.category.GetAllCategoryClientResponse;
import com.example.urshopmiddleware.client.category.GetByIdCategoryClientResponse;
import com.example.urshopmiddleware.client.category.UpdateCategoryClientRequest;
import com.example.urshopmiddleware.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class CategoryManager implements CategoryService {

    private final UrShopClient urShopClient;

    public CategoryManager(UrShopClient urShopClient) {
        this.urShopClient = urShopClient;
    }

    @Override
    public List<Category> getAll() {
        final List<GetAllCategoryClientResponse> categories = urShopClient.getAllCategories();
        return categories.stream().map(getAllCategoryResponse -> Category.builder()
                .categoryId(getAllCategoryResponse.id())
                .categoryName(getAllCategoryResponse.name())
                .productIds(getAllCategoryResponse.productIds())
                .build()
        ).toList();
    }

    @Override
    public Category getById(int categoryId) {
        final GetByIdCategoryClientResponse byIdCategoryResponse = urShopClient.getByIdCategoryResponse(categoryId);
        return Category.builder()
                .categoryId(byIdCategoryResponse.id())
                .categoryName(byIdCategoryResponse.name())
                .productIds(byIdCategoryResponse.productIds())
                .build();
    }

    @Override
    public void add(Category category) {
        urShopClient.addCategory(new CreateCategoryClientRequest(
                category.getCategoryName(),
                null
                /*category.getProducts().stream()
                        .map(product -> new com.example.urshopmiddleware.client.clientmodel.Product())
                        .collect(Collectors.toSet())*/));
    }

    @Override
    public void update(Category category) {
        if (Objects.nonNull(urShopClient.getByIdProduct(category.getCategoryId()))) {
            this.urShopClient.updateCategory(new UpdateCategoryClientRequest(category.getCategoryId(), category.getCategoryName()));
        } else {
            throw new RuntimeException("Category not found!");
        }

    }

    @Override
    public void delete(int categoryId) {
        if (Objects.nonNull(urShopClient.getByIdProduct(categoryId))) {
            this.urShopClient.deleteCategory(categoryId);
        } else {
            throw new RuntimeException("Category not found!");
        }
    }

}
