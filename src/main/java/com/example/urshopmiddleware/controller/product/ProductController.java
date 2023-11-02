package com.example.urshopmiddleware.controller.product;


import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.controller.BaseController;
import com.example.urshopmiddleware.model.Product;
import com.example.urshopmiddleware.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiConstants.PRODUCTS)
public class ProductController extends BaseController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping(ApiConstants.GET_ALL)
    public ResponseEntity<?> getAll() {
        List<GetAllProductsResponse> data = GetAllProductsResponse.fromProducts(productService.getAll());
        return success(data);
    }

    @GetMapping(ApiConstants.BY_ID)
    public ResponseEntity<?> getByIdProductResponse(@PathVariable int id) {
        GetByIdProductResponse data = GetByIdProductResponse.fromProduct(productService.getById(id));
        return success(data);
    }

    @PostMapping(ApiConstants.ADD)
    public void add(@RequestBody CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .productName(createProductRequest.name())
                .price(createProductRequest.price())
                .description(createProductRequest.description())
                .stock(createProductRequest.stock())
                .categoryId(createProductRequest.categoryId())
                .build();
        this.productService.add(product);
    }

    @PutMapping(ApiConstants.UPDATE + ApiConstants.BY_ID)
    public void update(@PathVariable int id, @RequestBody UpdateProductRequest updateProductRequest) {
        Product product = Product.builder()
                .productId(id)
                .productName(updateProductRequest.name())
                .price(updateProductRequest.price())
                .description(updateProductRequest.description())
                .stock(updateProductRequest.stock())
                .categoryId(updateProductRequest.categoryId())
                .build();
        this.productService.update(product);
    }

    @DeleteMapping(ApiConstants.BY_ID)
    public void delete(@PathVariable int id) {
        this.productService.delete(id);
    }


}


