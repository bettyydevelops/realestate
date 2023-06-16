package com.example.realestate.realestateagent;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RealEstateAgentResponse {

  Long id;
  String agentName;
  String authorizedPerson;
  String address;
  String phone;

}
