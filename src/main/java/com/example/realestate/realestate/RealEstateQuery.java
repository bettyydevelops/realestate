package com.example.realestate.realestate;

import lombok.Data;

@Data
public class RealEstateQuery {
  String city;
  String district;
  String type;
  Integer meterSquare;
  Integer roomCount;
  Integer flatFloor;
  Integer buildingFloorCount;
  boolean forSale;
}
