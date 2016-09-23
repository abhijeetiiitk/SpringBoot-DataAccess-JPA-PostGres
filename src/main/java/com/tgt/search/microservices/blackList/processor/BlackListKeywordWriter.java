package com.tgt.search.microservices.blackList.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgt.search.microservices.blackList.model.BlackListKeywordEntity;

@Component
public class BlackListKeywordWriter {

  @Autowired
  BlackListRepository blackListRepository;

  public void addToBlackListKeywordList(List<BlackListKeywordEntity> blackListKeywordList) {
    blackListRepository.save(blackListKeywordList);
  }
  
  public List<BlackListKeywordEntity> getAllBlackListkeywords() {
    return (List<BlackListKeywordEntity>) blackListRepository.findAll();
  }

}
