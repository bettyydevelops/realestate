package com.example.realestate.realestate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RealEstateService {

  RealEstateResponse createNewRealEstate(RealEstateRequest realEstateRequest);

  RealEstateResponse createRealEstateWithBuild(RealEstateRequest realEstateRequest);

  List<RealEstate> getRealEstates(RealEstateQuery realEstateQuery);
}
