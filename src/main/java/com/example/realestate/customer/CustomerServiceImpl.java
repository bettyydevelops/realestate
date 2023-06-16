package com.example.realestate.customer;

import com.example.realestate.realestateagent.RealEstateAgent;
import com.example.realestate.realestateagent.RealEstateAgentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository customerRepository;
  CustomerMapper customerMapper;
  RealEstateAgentService realEstateAgentService;

  @Override
  public CustomerResponse createNewCustomer(CustomerRequest customerRequest) {
    Customer customer = new Customer();
    customer.setFirstName(customerRequest.getFirstName());
    customer.setLastName(customerRequest.getLastName());
    customer.setAddress(customerRequest.getAddress());
    customer.setEmail(customerRequest.getEmail());
    List<RealEstateAgent> realEstateAgentList = realEstateAgentService.findAllByIdIn(customerRequest.getRealEstateAgentId());
    customer.setRealEstateAgents(new HashSet<>(realEstateAgentList));
    customerRepository.save(customer);
    return customerMapper.map(customer);
  }

  @Override
  public Customer findById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer with id: " + id + " is not found."));
  }
}
