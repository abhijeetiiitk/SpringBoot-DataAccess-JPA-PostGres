package com.tgt.search.microservices.blackList.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BlackListKeywordEntity {
  
  @Id
  @SequenceGenerator(name="seq-gen",sequenceName="BLACKLIST_ID_SEQ", initialValue=1111, allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
  @Column(name = "SERIALID")
  private Long serialId;

  @Column(name = "BLACKLISTKEYWORD")
  private String blackListKeyword;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "UPDATEDTIME", insertable = false, updatable = true,
	        columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
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
