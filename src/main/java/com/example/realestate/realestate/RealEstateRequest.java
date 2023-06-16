package com.example.realestate.realestate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RealEstateRequest {

  String city;
  String district;
  String type;
  @Positive
  Integer meterSquare;
  @Positive
  Integer roomCount;
  @PositiveOrZero
  Integer flatFloor;
  @PositiveOrZero
  Integer buildingFloorCount;
  private boolean forSale;
  Long customerId;

}
