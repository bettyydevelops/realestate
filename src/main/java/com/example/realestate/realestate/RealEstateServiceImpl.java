package com.example.realestate.realestate;

import com.example.realestate.customer.Customer;
import com.example.realestate.customer.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class RealEstateServiceImpl implements RealEstateService{

  RealEstateRepository realEstateRepository;
  RealEstateMapper realEstateMapper;
  CustomerService customerService;

  @Override
  public RealEstateResponse createNewRealEstate(RealEstateRequest realEstateRequest) {
    RealEstate realEstate = new RealEstate();
    realEstate.setCity(realEstateRequest.getCity());
    realEstate.setDistrict(realEstateRequest.getDistrict());
    realEstate.setType(realEstateRequest.getType());
    realEstate.setMeterSquare(realEstateRequest.getMeterSquare());
    realEstate.setRoomCount(realEstateRequest.getRoomCount());
    realEstate.setFlatFloor(realEstateRequest.getFlatFloor());
    realEstate.setBuildingFloorCount(realEstateRequest.getBuildingFloorCount());
    realEstate.setForSale(realEstateRequest.isForSale());
    Customer customer = customerService.findById(realEstateRequest.getCustomerId());
    realEstate.setCustomer(customer);
    realEstateRepository.save(realEstate);
    return realEstateMapper.map(realEstate);
  }

  @Override
  public RealEstateResponse createRealEstateWithBuild(RealEstateRequest realEstateRequest) {
    Customer customer = customerService.findById(realEstateRequest.getCustomerId());
    RealEstate realEstate = new RealEstateBuilder()
        .setCity(realEstateRequest.getCity())
        .setDistrict(realEstateRequest.getDistrict())
        .setType(realEstateRequest.getType())
        .setMeterSquare(realEstateRequest.getMeterSquare())
        .setRoomCount(realEstateRequest.getRoomCount())
        .setFlatFloor(realEstateRequest.getFlatFloor())
        .setBuildingFloorCount(realEstateRequest.getBuildingFloorCount())
        .setForSale(realEstateRequest.isForSale())
        .setCustomer(customer)
        .build();
    return realEstateMapper.map(realEstateRepository.save(realEstate));
  }

  @Override
  public List<RealEstate> getRealEstates(RealEstateQuery realEstateQuery) {
    return realEstateRepository.findByCriteria(realEstateQuery);
  }
}
