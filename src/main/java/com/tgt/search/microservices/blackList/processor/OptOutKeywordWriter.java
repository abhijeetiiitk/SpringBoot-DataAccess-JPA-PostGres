package com.tgt.search.microservices.blackList.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tgt.search.microservices.blackList.model.OptOutKeywordEntity;

@Service
public class OptOutKeywordWriter {

  @Autowired
  OptOutRepository optOutRepository;

  private static final int THRESHOLD_VAL = 2;
  private static final float BLACKLIST_ELIGIBLE_PERCENTAGE = 80.0f;

  public List<String> getAllBlackListKeyword() {
    return optOutRepository.findBlackListElegibleKeyword(THRESHOLD_VAL, BLACKLIST_ELIGIBLE_PERCENTAGE);
  }

  public boolean isOptOutKeywordExist(String optOutKeyword) {
    return optOutRepository.exist(optOutKeyword) != null && !StringUtils.isEmpty(optOutRepository.exist(optOutKeyword))
        ? true : false;
  }
  
  public OptOutKeywordEntity getOptOutKeyword(String optOutKeyword) {
    return optOutRepository.findByOptOutKeyword(optOutKeyword);
  }

  public void addToOptKeywordList(String OptOutKeyword, int frequency) {
    try {
      optOutRepository.save(new OptOutKeywordEntity(OptOutKeyword, frequency));
    } catch(Exception e) {
      
      
    }
    
  }

}
