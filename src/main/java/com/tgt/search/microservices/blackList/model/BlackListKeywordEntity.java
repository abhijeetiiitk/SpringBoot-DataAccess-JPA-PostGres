package com.tgt.search.microservices.blackList.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BlackListKeywordEntity {
  
  @Id
  @SequenceGenerator(name="seq-gen",sequenceName="BLACKLIST_ID_SEQ", initialValue=1111, allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
  @Column(name = "SERIALID")
  private Long serialId;

  @Column(name = "BLACKLISTKEYWORD")
  private String blackListKeyword;
  
  @Column(name = "UPDATEDTIME")
  private Date updatedTime;

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
