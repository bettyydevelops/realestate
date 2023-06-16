package com.example.realestate.customer;

import com.example.realestate.shared.SuccessResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
public class CustomerController {

  CustomerService customerService;

 @PostMapping
  public ResponseEntity<SuccessResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
    CustomerResponse customerResponse = customerService.createNewCustomer(customerRequest);
    SuccessResponse successResponse = new SuccessResponse(customerResponse, "New customer created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }


}
