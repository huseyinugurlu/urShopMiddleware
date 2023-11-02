package com.example.urshopmiddleware.product;


import com.example.urshopmiddleware.client.UrShopClient;
import com.example.urshopmiddleware.client.product.CreateProductClientRequest;
import com.example.urshopmiddleware.client.product.GetAllProductsClientResponse;
import com.example.urshopmiddleware.client.product.GetByIdProductClientResponse;
import com.example.urshopmiddleware.client.product.UpdateProductClientRequest;
import com.example.urshopmiddleware.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
    private final UrShopClient urShopClient;

    public ProductManager(UrShopClient urShopClient) {
        this.urShopClient = urShopClient;
    }

    @Override
    public List<Product> getAll() {
        final List<GetAllProductsClientResponse> products = urShopClient.getAllProducts();
        return products.stream().map(getAllProductsResponse -> Product.builder()
                .productId(getAllProductsResponse.id())
                .productName(getAllProductsResponse.name())
                .stock(getAllProductsResponse.stock())
                .price(getAllProductsResponse.price())
                .description(getAllProductsResponse.description())
                .categoryId(getAllProductsResponse.categoryId())
                .build()
        ).toList();
    }

    @Override
    public Product getById(int productId) {
        final GetByIdProductClientResponse byIdProductResponse = urShopClient.getByIdProduct(productId);
        if (Objects.nonNull(byIdProductResponse)) {
            return Product.builder()
                    .productId(byIdProductResponse.id())
                    .productName(byIdProductResponse.name())
                    .price(byIdProductResponse.price())
                    .stock(byIdProductResponse.stock())
                    .description(byIdProductResponse.description())
                    .categoryId(byIdProductResponse.categoryId())
                    .build();
        } else {
            throw new RuntimeException("Product not found!");
        }
    }

    @Override
    public List<Product> getByCategory(int categoryId) {
        return urShopClient.getByCategoryId(categoryId).stream()
                .map(getAllProductsClientResponse ->
                        Product.builder()
                                .productName(getAllProductsClientResponse.name())
                                .price(getAllProductsClientResponse.price())
                                .stock(getAllProductsClientResponse.stock())
                                .description(getAllProductsClientResponse.description())
                                .categoryId(getAllProductsClientResponse.categoryId())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public void add(Product product) {
        this.urShopClient.addProduct(new CreateProductClientRequest(
                product.getProductName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription(),
                product.getCategoryId()
        ));
    }

    @Override
    public void update(Product product) {
        getById(product.getProductId());
        this.urShopClient.updateProduct(product.getProductId(), new UpdateProductClientRequest(
                product.getProductName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription(),
                product.getCategoryId()
        ));
    }

    @Override
    public void delete(int productId) {
        getById(productId);
        this.urShopClient.deleteProduct(productId);

    }
}
