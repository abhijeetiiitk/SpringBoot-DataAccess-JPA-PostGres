package com.tgt.search.microservices.blackList.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OptOutKeywordEntity {

	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "OPTOUT_ID_SEQ", initialValue = 1111, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
	@Column(name = "SERIALID")
	private Long serialId;

	@Column(name = "OPTOUTKEYWORD")
	private String optOutKeyword;

	@Column(name = "KEYWORDFREQUENCY")
	private int keywordFrequency;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDTIME", insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedTime;

	public OptOutKeywordEntity(String blackListKeyword, int keywordFrequency) {
		super();
		this.optOutKeyword = blackListKeyword;
		this.keywordFrequency = keywordFrequency;
	}

	@PrePersist
	protected void onCreate() {
		updatedTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedTime = new Date();
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
