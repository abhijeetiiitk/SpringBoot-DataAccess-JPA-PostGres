package com.tgt.search.microservices.blackList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgt.search.microservices.blackList.model.OptOutKeywordEntity;
import com.tgt.search.microservices.blackList.processor.BlackListKeywordReader;
import com.tgt.search.microservices.blackList.processor.OptOutKeywordWriter;

@RestController
public class BlackListController {

	@Autowired
	OptOutKeywordWriter optOutKeywordWriter;

	@Autowired
	BlackListKeywordReader blackListKeywordReader;

	private final int BASE_OCCURRANCE = 1;

	@RequestMapping("/blacklist/{optOutKeyword}")
	public void addToOptOutKeywordList(@PathVariable("optOutKeyword") String optOutKeyword) {
		OptOutKeywordEntity keywordEntity = optOutKeywordWriter.getOptOutKeyword(optOutKeyword);
		if (keywordEntity != null) {
			int frequency = keywordEntity.getKeywordFrequency() + BASE_OCCURRANCE;
			optOutKeywordWriter.addToOptKeywordList(optOutKeyword, frequency);
		} else {
			optOutKeywordWriter.addToOptKeywordList(optOutKeyword, BASE_OCCURRANCE);
		}
	}

	@RequestMapping("/blacklist/getBlackListQueries")
	public List<String> getKeywordList() {
		List<String> blackList = blackListKeywordReader.readBlackListKeyword();
		return blackList;
	}

	@RequestMapping("/blacklist/writeToBlackList")
	public void writeBlackList() {
		blackListKeywordReader.writeBlackListKeywords();
	}

}
