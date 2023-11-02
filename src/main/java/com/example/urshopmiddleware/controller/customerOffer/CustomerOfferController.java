package com.example.urshopmiddleware.controller.customerOffer;

import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.controller.BaseController;
import com.example.urshopmiddleware.customerOffer.CustomerOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.CUSTOMER_OFFER)
public class CustomerOfferController extends BaseController {
    private final CustomerOfferService customerOfferService;

    @Autowired
    public CustomerOfferController(CustomerOfferService customerOfferService) {
        this.customerOfferService = customerOfferService;
    }

    @GetMapping(ApiConstants.GET_ALL)
    public ResponseEntity<?> getAll() {
        List<GetAllOfferResponse> data = GetAllOfferResponse.fromOffers(customerOfferService.getAll());
        return success(data);
    }

    @GetMapping(ApiConstants.BY_ID)
    public ResponseEntity<?> getByIdCustomerOfferResponse(@PathVariable int id) {
        GetByIdOfferResponse data = GetByIdOfferResponse.fromOffer(customerOfferService.getById(id));
        return success(data);
    }

    @DeleteMapping(ApiConstants.BY_ID)
    public void delete(@PathVariable int id) {
        this.customerOfferService.delete(id);
    }
}
