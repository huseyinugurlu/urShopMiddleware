package com.example.urshopmiddleware.customerOffer;

import com.example.urshopmiddleware.client.UrShopClient;
import com.example.urshopmiddleware.model.CustomerOffer;
import com.example.urshopmiddleware.model.Product;
import com.example.urshopmiddleware.model.ProductCustomerOfferMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerOfferManager implements CustomerOfferService {
  private final UrShopClient urShopClient;

  public CustomerOfferManager(UrShopClient urShopClient) {
    this.urShopClient = urShopClient;
  }

  @Override
  public List<CustomerOffer> getAll() {
    return urShopClient.getAllCustomerOffer().stream()
            .map(getAllOfferResponse ->CustomerOffer.builder()
                    .totalAmount(getAllOfferResponse.totalAmount())
                    .productCustomerOfferMapIds(getAllOfferResponse.clientProductCustomerOfferMapIds())
                    .build()
            ).toList();
  }

  @Override
  public CustomerOffer getById(int offerId) {
    return null;
  }

  @Override
  public void delete(int offerId) {
    /*if (customerOfferRepository.existsById(offerId)) {
      this.customerOfferRepository.deleteById(offerId);
    } else {
      throw new BusinessException("Customer Offer not found!");
    }*/
  }
}
