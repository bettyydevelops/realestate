package com.example.realestate.realestate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RealEstateResponse {

  Long id;
  String city;
  String district;
  String type;
  Integer meterSquare;
  Integer roomCount;
  Integer flatFloor;
  Integer buildingFloorCount;
  boolean forSale;
  long customerId;

}
