package com.example.realestate.realestateagent;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RealEstateAgentService {

  RealEstateAgentResponse createNewRealEstateAgent(RealEstateAgentRequest realEstateAgentRequest);

  List<RealEstateAgent> findAllByIdIn(List<Long> idList);
}
