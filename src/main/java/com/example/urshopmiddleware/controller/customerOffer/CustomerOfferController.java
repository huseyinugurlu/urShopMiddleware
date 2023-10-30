package com.example.urshopmiddleware.controller.customerOffer;

import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.customerOffer.CustomerOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.CUSTOMER_OFFER)
public class CustomerOfferController{
  private final CustomerOfferService customerOfferService;

  @Autowired
  public CustomerOfferController(CustomerOfferService customerOfferService) {
    this.customerOfferService = customerOfferService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllOfferResponse> getAll() {
    return GetAllOfferResponse.fromOffers(customerOfferService.getAll());
  }

  /*@GetMapping(ApiConstants.BY_ID)
  public GetByIdOfferResponse getByIdCustomerOfferResponse(@PathVariable int id) {
    return GetByIdOfferResponse.fromOffer(customerOfferService.getById(id));
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.customerOfferService.delete(id);
  }*/
}
