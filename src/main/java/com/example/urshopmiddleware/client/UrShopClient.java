package com.example.urshopmiddleware.client;

import com.example.urshopmiddleware.client.auth.AuthClientRequest;
import com.example.urshopmiddleware.client.cashier.CreateCashierClientRequest;
import com.example.urshopmiddleware.client.cashier.GetAllCashierClientResponse;
import com.example.urshopmiddleware.client.cashier.GetByIdCashierClientResponse;
import com.example.urshopmiddleware.client.cashier.UpdateCashierClientRequest;
import com.example.urshopmiddleware.client.category.CreateCategoryClientRequest;
import com.example.urshopmiddleware.client.category.GetAllCategoryClientResponse;
import com.example.urshopmiddleware.client.category.GetByIdCategoryClientResponse;
import com.example.urshopmiddleware.client.category.UpdateCategoryClientRequest;
import com.example.urshopmiddleware.client.customer.CreateCustomerClientRequest;
import com.example.urshopmiddleware.client.customer.GetAllCustomerClientResponse;
import com.example.urshopmiddleware.client.customer.GetByIdCustomerClientResponse;
import com.example.urshopmiddleware.client.customer.UpdateCustomerClientRequest;
import com.example.urshopmiddleware.client.customerOffer.GetAllOfferClientResponse;
import com.example.urshopmiddleware.client.customerOffer.GetByIdOfferClientResponse;
import com.example.urshopmiddleware.client.order.CreateOrderClientRequest;
import com.example.urshopmiddleware.client.order.GetAllOrderClientResponse;
import com.example.urshopmiddleware.client.order.GetByIdOrderClientResponse;
import com.example.urshopmiddleware.client.paymentCard.CreatePaymentCardRequest;
import com.example.urshopmiddleware.client.paymentCard.GetAllPaymentCardResponse;
import com.example.urshopmiddleware.client.paymentCard.GetByIdPaymentCardResponse;
import com.example.urshopmiddleware.client.paymentCard.UpdatePaymentCardClientRequest;
import com.example.urshopmiddleware.client.product.CreateProductClientRequest;
import com.example.urshopmiddleware.client.product.GetAllProductsClientResponse;
import com.example.urshopmiddleware.client.product.GetByIdProductClientResponse;
import com.example.urshopmiddleware.client.product.UpdateProductClientRequest;
import com.example.urshopmiddleware.client.productCustomerOfferMap.GetProductCustomerOfferMapClientResponse;
import com.example.urshopmiddleware.client.productFeatureValueMap.GetProductFeatureValueMapClientResponse;
import com.example.urshopmiddleware.client.user.GetAllUserClientResponse;
import com.example.urshopmiddleware.client.user.GetByIdUserClientResponse;
import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.controller.auth.ResetPswrdRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "urshop-client", url = "http://localhost:8080/api")
public interface UrShopClient {


    //***AUTH

    @PostMapping(ApiConstants.AUTH + ApiConstants.LOGIN)
    AuthClientRequest authenticateAndGetToken(@RequestBody AuthClientRequest clientAuthRequest);

    @PostMapping(ApiConstants.AUTH + ApiConstants.CHANGE_PASSWORD)
    void changePassword(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody final ResetPswrdRequest resetPswrdRequest);

    //***CATEGORY

    @GetMapping(ApiConstants.CATEGORIES + ApiConstants.GET_ALL)
    List<GetAllCategoryClientResponse> getAllCategories();

    @GetMapping(ApiConstants.CATEGORIES + ApiConstants.BY_ID)
    GetByIdCategoryClientResponse getByIdCategoryResponse(@PathVariable int id);

    @PostMapping(ApiConstants.CATEGORIES + ApiConstants.ADD)
    void addCategory(@RequestBody CreateCategoryClientRequest createCategoryClientRequest);

    @PutMapping(ApiConstants.CATEGORIES + ApiConstants.UPDATE)
    void updateCategory(@RequestBody final UpdateCategoryClientRequest updateCategoryClientRequest);

    @DeleteMapping(ApiConstants.CATEGORIES + ApiConstants.BY_ID)
    void deleteCategory(@PathVariable int id);

    //***PRODUCT

    @GetMapping(ApiConstants.PRODUCTS + ApiConstants.GET_ALL)
    List<GetAllProductsClientResponse> getAllProducts();

    @GetMapping(ApiConstants.PRODUCTS + ApiConstants.BY_ID)
    GetByIdProductClientResponse getByIdProduct(@PathVariable int id);

    @GetMapping(ApiConstants.GET_BY_CATEGORY_ID + ApiConstants.BY_ID)
    List<GetAllProductsClientResponse> getByCategoryId(@PathVariable int id);

    @PostMapping(ApiConstants.PRODUCTS + ApiConstants.ADD)
    void addProduct(@RequestBody CreateProductClientRequest createProductClientRequest);

    @PutMapping(ApiConstants.PRODUCTS + ApiConstants.UPDATE)
    void updateProduct(@RequestBody final UpdateProductClientRequest updateProductClientRequest);

    @DeleteMapping(ApiConstants.PRODUCTS + ApiConstants.BY_ID)
    void deleteProduct(@PathVariable int id);

    //***CUSTOMER OFFER

    @GetMapping(ApiConstants.CUSTOMER_OFFER + ApiConstants.GET_ALL)
    List<GetAllOfferClientResponse> getAllCustomerOffer();

    @GetMapping(ApiConstants.CUSTOMER_OFFER + ApiConstants.BY_ID)
    GetByIdOfferClientResponse getByIdCustomerOffer(@PathVariable int id);

    @DeleteMapping(ApiConstants.CUSTOMER_OFFER + ApiConstants.BY_ID)
    void deleteCustomerOffer(@PathVariable int id);

    //***ORDER

    @GetMapping(ApiConstants.ORDERS + ApiConstants.GET_ALL)
    List<GetAllOrderClientResponse> getAllOrder();

    @GetMapping(ApiConstants.ORDERS + ApiConstants.BY_ID)
    GetByIdOrderClientResponse getByIdOrder(@PathVariable int id);

    @PostMapping(ApiConstants.ORDERS + ApiConstants.ADD)
    void addOrder(@RequestBody CreateOrderClientRequest createOrderClientRequest);

    @DeleteMapping(ApiConstants.ORDERS + ApiConstants.BY_ID)
    void deleteOrder(@PathVariable int id);

    //***PAYMENT CARD

    @GetMapping(ApiConstants.PAYMENT_CARDS + ApiConstants.GET_ALL)
    List<GetAllPaymentCardResponse> getAllPaymentCard();

    @GetMapping(ApiConstants.PAYMENT_CARDS + ApiConstants.BY_ID)
    GetByIdPaymentCardResponse getByIdPaymentCard(@PathVariable int id);

    @PostMapping(ApiConstants.PAYMENT_CARDS + ApiConstants.ADD)
    void addPaymentCard(@RequestBody CreatePaymentCardRequest createPaymentCardRequest);

    @PutMapping(ApiConstants.PAYMENT_CARDS + ApiConstants.ADD)
    void updatePaymentCard(
            @PathVariable int id, @RequestBody final UpdatePaymentCardClientRequest updatePaymentCardClientRequest);

    @DeleteMapping(ApiConstants.PAYMENT_CARDS + ApiConstants.BY_ID)
    void deletePaymentCard(@PathVariable int id);

    //***PRODUCT CUSTOMER OFFER MAP

    @GetMapping(ApiConstants.PRODUCT_CUSTOMER_OFFER_MAP + ApiConstants.GET_ALL)
    List<GetProductCustomerOfferMapClientResponse> getAllProductCustomerOfferMap();

    @GetMapping(ApiConstants.PRODUCT_CUSTOMER_OFFER_MAP + ApiConstants.GET_BY_PRODUCT_ID + ApiConstants.BY_ID)
    List<GetProductCustomerOfferMapClientResponse> getByIdProductCustomerOfferMap(@PathVariable int id);

    //***PRODUCT FEATURE VALUE MAP

    @GetMapping(ApiConstants.PRODUCT_FEATURE_VALUE_MAP + ApiConstants.GET_ALL)
    List<GetProductFeatureValueMapClientResponse> getAllProductFeatureValueMaps();

    @GetMapping(ApiConstants.PRODUCT_FEATURE_VALUE_MAP + ApiConstants.GET_BY_FEATURE_ID + ApiConstants.BY_ID)
    List<GetProductFeatureValueMapClientResponse> getByFeatureIdMap(@PathVariable int id);

    @GetMapping(ApiConstants.PRODUCT_FEATURE_VALUE_MAP + ApiConstants.GET_BY_PRODUCT_ID + ApiConstants.BY_ID)
    List<GetProductFeatureValueMapClientResponse> getByProductIdMap(@PathVariable int id);

    //***CASHIER

    @GetMapping(ApiConstants.CASHIER + ApiConstants.GET_ALL)
    List<GetAllCashierClientResponse> getAllCashier();

    @GetMapping(ApiConstants.CASHIER + ApiConstants.BY_ID)
    GetByIdCashierClientResponse getByIdCashier(@PathVariable int id);

    @PostMapping(ApiConstants.CASHIER + ApiConstants.ADD)
    void addCashier(@RequestBody CreateCashierClientRequest createCashierRequest);

    @PutMapping(ApiConstants.CASHIER + ApiConstants.UPDATE)
    void updateCashier(@RequestBody final UpdateCashierClientRequest updateCashierRequest);

    @DeleteMapping(ApiConstants.CASHIER + ApiConstants.BY_ID)
    void deleteCashier(@PathVariable int id);

    //***CUSTOMER

    @GetMapping(ApiConstants.CUSTOMER + ApiConstants.GET_ALL)
    List<GetAllCustomerClientResponse> getAllCustomer();

    @GetMapping(ApiConstants.CUSTOMER + ApiConstants.BY_ID)
    GetByIdCustomerClientResponse getByIdCustomer(@PathVariable int id);

    @PostMapping(ApiConstants.CUSTOMER + ApiConstants.ADD)
    void addCustomer(@RequestBody CreateCustomerClientRequest createCustomerClientRequest);

    @PutMapping(ApiConstants.CUSTOMER + ApiConstants.UPDATE)
    void updateCustomer(@RequestBody final UpdateCustomerClientRequest updateCustomerClientRequest);

    @DeleteMapping(ApiConstants.CUSTOMER + ApiConstants.BY_ID)
    void deleteCustomer(@PathVariable int id);

    //***USER

    @GetMapping(ApiConstants.GET_ALL)
    List<GetAllUserClientResponse> getAllUser();

    @GetMapping(ApiConstants.BY_ID)
    GetByIdUserClientResponse getByIdUser(@PathVariable int id);
}