package com.tgt.search.microservices.blackList.processor;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tgt.search.microservices.blackList.model.BlackListKeywordEntity;

@Component
public class BlackListKeywordReader {

  @Autowired
  OptOutKeywordWriter optOutKeywordWriter;

  @Autowired
  BlackListKeywordWriter blackListKeywordWriter;

  private static final Logger log = LoggerFactory.getLogger(BlackListKeywordReader.class);

  //@Scheduled(fixedRate = 3000)
  public void writeBlackListKeywords() {
    blackListKeywordWriter.addToBlackListKeywordList(optOutKeywordWriter.getAllBlackListKeyword().stream()
        .map(keywordEntity -> new BlackListKeywordEntity(keywordEntity)).collect(Collectors.toList()));
  }

  public List<String> readBlackListKeyword() {
    return blackListKeywordWriter.getAllBlackListkeywords().stream()
        .map(keywordEntity -> keywordEntity.getBlackListKeyword()).collect(Collectors.toList());
  }

}
