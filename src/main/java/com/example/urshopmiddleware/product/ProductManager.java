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
        return Product.builder()
                .productName(byIdProductResponse.name())
                .price(byIdProductResponse.price())
                .stock(byIdProductResponse.stock())
                .description(byIdProductResponse.description())
                .categoryId(byIdProductResponse.categoryId())
                .build();
    }

    @Override
    public List<Product> getByCategory(int categoryId) {
        return null;//productRepository.findProductByCategory_CategoryId(categoryId);
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
    if (Objects.nonNull(urShopClient.getByIdProduct(product.getProductId()))) {
      this.urShopClient.updateProduct(new UpdateProductClientRequest(
              product.getProductId(),
              product.getProductName(),
              product.getPrice(),
              product.getStock(),
              product.getDescription(),
              product.getCategoryId()
              ));
    } else {
      throw new RuntimeException("Product not found!");
    }
    }

    @Override
    public void delete(int productId) {
        if (Objects.nonNull(urShopClient.getByIdProduct(productId))) {
            this.urShopClient.deleteProduct(productId);
        } else {
            throw new RuntimeException("Product not found!");
        }
    }
}
