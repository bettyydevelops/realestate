package com.example.realestate.realestateagent;

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
public class RealEstateAgentServiceImpl implements RealEstateAgentService {

  RealEstateAgentRepository realEstateAgentRepository;
  RealEstateAgentMapper realEstateAgentMapper;

  @Override
  public RealEstateAgentResponse createNewRealEstateAgent(RealEstateAgentRequest realEstateAgentRequest) {
    RealEstateAgent realEstateAgent = realEstateAgentMapper.map(realEstateAgentRequest);
    realEstateAgentRepository.save(realEstateAgent);
    return realEstateAgentMapper.map(realEstateAgent);
  }

  public List<RealEstateAgent> findAllByIdIn(List<Long> idList) {
    return realEstateAgentRepository.findAllById(idList);
  }
}
