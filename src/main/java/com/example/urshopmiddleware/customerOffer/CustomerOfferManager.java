package com.example.urshopmiddleware.customerOffer;

import com.example.urshopmiddleware.client.UrShopClient;
import com.example.urshopmiddleware.client.customerOffer.GetByIdOfferClientResponse;
import com.example.urshopmiddleware.model.CustomerOffer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerOfferManager implements CustomerOfferService {
    private final UrShopClient urShopClient;

    public CustomerOfferManager(UrShopClient urShopClient) {
        this.urShopClient = urShopClient;
    }

    @Override
    public List<CustomerOffer> getAll() {
        return urShopClient.getAllCustomerOffer().stream()
                .map(getAllOfferResponse -> CustomerOffer.builder()
                        .totalAmount(getAllOfferResponse.totalAmount())
                        .productCustomerOfferMapIds(getAllOfferResponse.clientProductCustomerOfferMapIds())
                        .build()
                ).toList();
    }

    @Override
    public CustomerOffer getById(int offerId) {
        final GetByIdOfferClientResponse byIdCustomerOffer = urShopClient.getByIdCustomerOffer(offerId);
        if (Objects.nonNull(byIdCustomerOffer)) {
            return CustomerOffer.builder()
                    .id(byIdCustomerOffer.id())
                    .totalAmount(byIdCustomerOffer.totalAmount())
                    .productCustomerOfferMapIds(byIdCustomerOffer.productIds())
                    .build();
        } else {
            throw new RuntimeException("Customer Offer not found!");
        }

    }

    @Override
    public void delete(int offerId) {
        getById(offerId);
        this.urShopClient.deleteCustomerOffer(offerId);

    }
}
