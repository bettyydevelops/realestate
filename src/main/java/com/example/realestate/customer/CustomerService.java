package com.example.realestate.customer;

import javax.transaction.Transactional;

@Transactional
public interface CustomerService {

  CustomerResponse createNewCustomer(CustomerRequest customerRequest);

  Customer findById(Long id);
}
