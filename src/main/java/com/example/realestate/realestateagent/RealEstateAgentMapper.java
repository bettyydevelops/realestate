package com.example.realestate.realestateagent;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RealEstateAgentMapper {

  public List<RealEstateAgentResponse> map(Set<RealEstateAgent> realEstateAgentSet) {
    return realEstateAgentSet.stream().map(this::map).collect(Collectors.toList());
  }

  public RealEstateAgentResponse map(RealEstateAgent realEstateAgent) {
    RealEstateAgentResponse realEstateAgentResponse = new RealEstateAgentResponse();
    realEstateAgentResponse.setId(realEstateAgent.getId());
    realEstateAgentResponse.setAgentName(realEstateAgent.getAgentName());
    realEstateAgentResponse.setAuthorizedPerson(realEstateAgent.getAuthorizedPerson());
    realEstateAgentResponse.setPhone(realEstateAgent.getPhone());
    realEstateAgentResponse.setAddress(realEstateAgent.getAddress());
    return realEstateAgentResponse;
  }

  public RealEstateAgent map(RealEstateAgentRequest realEstateAgentRequest) {
    RealEstateAgent realEstateAgent = new RealEstateAgent();
    realEstateAgent.setAgentName(realEstateAgentRequest.getAgentName());
    realEstateAgent.setAuthorizedPerson(realEstateAgentRequest.getAuthorizedPerson());
    realEstateAgent.setPhone(realEstateAgentRequest.getPhone());
    realEstateAgent.setAddress(realEstateAgentRequest.getAddress());
    return realEstateAgent;
  }
}
