package com.example.realestate.realestate;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RealEstateMapper {
  public List<RealEstateResponse> map(Set<RealEstate> realEstateSet) {
    return realEstateSet.stream().map(this::map).collect(Collectors.toList());
  }

  public RealEstateResponse map(RealEstate realEstate) {
    RealEstateResponse realEstateResponse = new RealEstateResponse();
    realEstateResponse.setId(realEstate.getId());
    realEstateResponse.setCity(realEstate.getCity());
    realEstateResponse.setDistrict(realEstate.getDistrict());
    realEstateResponse.setBuildingFloorCount(realEstate.getBuildingFloorCount());
    realEstateResponse.setFlatFloor(realEstate.getFlatFloor());
    realEstateResponse.setType(realEstate.getType());
    realEstateResponse.setMeterSquare(realEstate.getMeterSquare());
    realEstateResponse.setRoomCount(realEstate.getRoomCount());
    realEstateResponse.setForSale(realEstate.isForSale());
    realEstateResponse.setCustomerId(realEstate.getCustomer().getId());
    return realEstateResponse;
  }

  public RealEstate map(RealEstateRequest realEstateRequest) {
    RealEstate realEstate = new RealEstate();
    realEstate.setCity(realEstateRequest.getCity());
    realEstate.setDistrict(realEstateRequest.getDistrict());
    realEstate.setBuildingFloorCount(realEstateRequest.getBuildingFloorCount());
    realEstate.setFlatFloor(realEstateRequest.getFlatFloor());
    realEstate.setType(realEstateRequest.getCity());
    realEstate.setMeterSquare(realEstateRequest.getMeterSquare());
    realEstate.setRoomCount(realEstateRequest.getRoomCount());
    realEstate.setForSale(realEstateRequest.isForSale());
    return realEstate;
  }
}
