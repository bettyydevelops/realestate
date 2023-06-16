package com.example.realestate.realestateagent;

import com.example.realestate.shared.SuccessResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/real-estate-agent")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
public class RealEstateAgentController {

  RealEstateAgentService realEstateAgentService;

  @PostMapping
  public ResponseEntity<SuccessResponse> createRealEstateAgent(@Valid @RequestBody RealEstateAgentRequest realEstateAgentRequest) {
    RealEstateAgentResponse realEstateAgentResponse = realEstateAgentService.createNewRealEstateAgent(realEstateAgentRequest);
    SuccessResponse successResponse = new SuccessResponse(realEstateAgentResponse, "New real estate agent created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

}
