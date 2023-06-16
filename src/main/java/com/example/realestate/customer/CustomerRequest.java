package com.example.realestate.customer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

  @NotNull
  String firstName;
  @NotNull
  String lastName;
  @NotNull
  String address;
  @NotNull
  String email;
  List<Long> realEstateAgentId;

}
