package com.example.realestate.customer;


import com.example.realestate.realestateagent.RealEstateAgentResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

  Long id;
  String firstName;
  String lastName;
  String address;
  String email;
  List<RealEstateAgentResponse> realEstateAgents;
}
