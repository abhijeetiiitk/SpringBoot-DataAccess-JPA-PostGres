package com.tgt.search.microservices.blackList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OptOutKeywordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "SERIAL_ID")
	private Long id;

	@Column(name = "OPTOUT_QUERY")
	private String optOutKeyword;

	@Column(name = "FREQUENCY")
	private int keywordFrequency;
	
  @Column(name = "TIME_UPDATED")
	private int updatedTime;

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
