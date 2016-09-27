package com.tgt.search.microservices.blackList.processor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgt.search.microservices.blackList.model.OptOutKeywordEntity;

@Service
public class OptOutKeywordWriter {

	@Autowired
	OptOutRepository optOutRepository;

	private static final int THRESHOLD_VAL = 2;
	private static final int BLACKLIST_ELIGIBLE_PERCENTAGE = 80;

	public List<String> getAllBlackListKeyword() {
		return optOutRepository.findBlackListElegibleKeyword(THRESHOLD_VAL, BLACKLIST_ELIGIBLE_PERCENTAGE);
	}

	public boolean isOptOutKeywordExist(String optOutKeyword) {
		return optOutRepository.exist(optOutKeyword) != null ? true : false;
	}

	public OptOutKeywordEntity getOptOutKeyword(String optOutKeyword) {
		return isOptOutKeywordExist(optOutKeyword) ? optOutRepository.findByOptOutKeyword(optOutKeyword) : null;
	}

	public void addToOptKeywordList(String OptOutKeyword, int frequency) {
		try {
			optOutRepository.save(new OptOutKeywordEntity(OptOutKeyword, frequency));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void updateKeywordFrequency(int keywordFrequency, String optOutKeyword) {
		optOutRepository.updateKeywordFrequency(keywordFrequency, optOutKeyword);
	}

}
