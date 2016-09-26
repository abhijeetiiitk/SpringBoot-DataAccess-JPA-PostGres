package com.tgt.search.microservices.blackList.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class OptOutKeywordEntity {

	@Id
	@SequenceGenerator(name="seq-gen",sequenceName="OPTOUT_ID_SEQ", initialValue=1111, allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
	@Column(name = "SERIALID")
	private Long serialId;

	@Column(name = "OPTOUTKEYWORD")
	private String optOutKeyword;

	@Column(name = "KEYWORDFREQUENCY")
	private int keywordFrequency;
	
  @Column(name = "UPDATEDTIME")
	private Date updatedTime;

	public OptOutKeywordEntity(String blackListKeyword, int keywordFrequency) {
		super();
		this.optOutKeyword = blackListKeyword;
		this.keywordFrequency = keywordFrequency;
	}
	
	 public int getKeywordFrequency() {
	    return keywordFrequency;
	  }

	protected OptOutKeywordEntity() {
	}

	@Override
	public String toString() {
		return String.format("BlackListKeywordEntity[optOutKeyword=%s,keywordFrequency=%s]", optOutKeyword,
				keywordFrequency);
	}

}
