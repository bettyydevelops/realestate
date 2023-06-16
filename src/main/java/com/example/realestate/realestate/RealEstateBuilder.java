package com.example.realestate.realestate;

import com.example.realestate.customer.Customer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RealEstateBuilder {

  String city;
  String district;
  String type;
  Integer meterSquare;
  Integer roomCount;
  Integer flatFloor;
  Integer buildingFloorCount;
  boolean forSale = true;
  Customer customer;

  public RealEstateBuilder() {

  }
  public RealEstateBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public RealEstateBuilder setDistrict(String district) {
    this.district = district;
    return this;
  }

  public RealEstateBuilder setType(String type) {
    this.type = type;
    return this;
  }

  public RealEstateBuilder setMeterSquare(Integer meterSquare) {
    this.meterSquare = meterSquare;
    return this;
  }

  public RealEstateBuilder setRoomCount(Integer roomCount) {
    this.roomCount = roomCount;
    return this;
  }

  public RealEstateBuilder setFlatFloor(Integer flatFloor) {
    this.flatFloor = flatFloor;
    return this;
  }

  public RealEstateBuilder setBuildingFloorCount(Integer buildingFloorCount) {
    this.buildingFloorCount = buildingFloorCount;
    return this;
  }

  public RealEstateBuilder setForSale(boolean forSale) {
    this.forSale = forSale;
    return this;
  }

  public RealEstateBuilder setCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }


  public RealEstate build() {
    return new RealEstate(city, district, type, meterSquare, roomCount, flatFloor, buildingFloorCount, forSale, customer );
  }

}
