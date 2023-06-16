package com.example.realestate.realestateagent;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RealEstateAgentRequest {

  @NotNull
  String agentName;
  @NotNull
  String authorizedPerson;
  @NotNull
  String address;
  @NotNull
  String phone;

}
