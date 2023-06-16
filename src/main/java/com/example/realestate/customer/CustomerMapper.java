package com.example.realestate.customer;

import com.example.realestate.realestateagent.RealEstateAgentMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerMapper {

  RealEstateAgentMapper realEstateAgentMapper;

  public List<CustomerResponse> map(Set<Customer> customerSet) {
    return customerSet.stream().map(this::map).collect(Collectors.toList());
  }

  public CustomerResponse map(Customer customer) {
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setId(customer.getId());
    customerResponse.setFirstName(customer.getFirstName());
    customerResponse.setLastName(customer.getLastName());
    customerResponse.setEmail(customer.getEmail());
    customerResponse.setAddress(customer.getAddress());
    customerResponse.setRealEstateAgents(realEstateAgentMapper.map(customer.getRealEstateAgents()));
    return customerResponse;
  }

  public Customer map(CustomerRequest customerRequest) {
    Customer customer = new Customer();
    customer.setFirstName(customerRequest.getFirstName());
    customer.setLastName(customerRequest.getLastName());
    customer.setEmail(customerRequest.getEmail());
    customer.setAddress(customerRequest.getAddress());
    return customer;
  }
}
