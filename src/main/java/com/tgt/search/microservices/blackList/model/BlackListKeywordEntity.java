package com.tgt.search.microservices.blackList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlackListKeywordEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "SERIAL_ID")
  private Long id;

  @Column(name = "BLACKLIST_QUERY")
  private String blackListKeyword;
  
  @Column(name = "TIME_UPDATED")
  private int updatedTime;

  public BlackListKeywordEntity(String blackListKeyword) {
    super();
    this.blackListKeyword = blackListKeyword;
  }
  
  protected BlackListKeywordEntity(){
  }
  
  public String getBlackListKeyword() {
    return blackListKeyword;
  }
  
  @Override
  public String toString() {
    return String.format("BlackListKeywordEntity[blackListKeyword=%s]", blackListKeyword);
  }

}
