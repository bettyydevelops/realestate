package com.example.realestate.realestate;

import com.example.realestate.shared.SuccessResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/real-estate")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
public class RealEstateController {

  RealEstateService realEstateService;
  RealEstateMapper realEstateMapper;

 /* @PostMapping()
  public ResponseEntity<SuccessResponse> createRealEstate(@Valid @RequestBody RealEstateRequest realEstateRequest) {
    RealEstateResponse realEstateResponse = realEstateService.createNewRealEstate(realEstateRequest);
    SuccessResponse successResponse = new SuccessResponse(realEstateResponse, "New real estate created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }*/

  @GetMapping
  public ResponseEntity<SuccessResponse> getRealEstates(RealEstateQuery realEstateQuery) {

    List<RealEstate> realEstateList  = realEstateService.
        getRealEstates(realEstateQuery);
    List<RealEstateResponse> realEstateResponseList = realEstateList.stream().map(x -> {
      return realEstateMapper.map(x);
    }).collect(Collectors.toList());
    SuccessResponse successResponse = new SuccessResponse(realEstateResponseList, "Real estate found.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

  @PostMapping()
  public ResponseEntity<SuccessResponse> createRealEstateWithBuild(@Valid @RequestBody RealEstateRequest realEstateRequest) {
    RealEstateResponse realEstateResponse = realEstateService.createRealEstateWithBuild(realEstateRequest);
    SuccessResponse successResponse = new SuccessResponse(realEstateResponse, "New real estate created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

}
