package com.tgt.search.microservices.blackList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgt.search.microservices.blackList.model.OptOutKeywordEntity;
import com.tgt.search.microservices.blackList.processor.BlackListKeywordReader;
import com.tgt.search.microservices.blackList.processor.OptOutKeywordWriter;

@RestController
@RequestMapping("/blacklist")
public class BlackListController {

	@Autowired
	OptOutKeywordWriter optOutKeywordWriter;

	@Autowired
	BlackListKeywordReader blackListKeywordReader;

	private final int BASE_OCCURRANCE = 1;

	@RequestMapping(value = "/{optOutKeyword}")
	public void addToOptOutKeywordList(@PathVariable String optOutKeyword) {
		OptOutKeywordEntity keywordEntity = optOutKeywordWriter.getOptOutKeyword(optOutKeyword);
		if (keywordEntity != null) {
			int frequency = keywordEntity.getKeywordFrequency() + BASE_OCCURRANCE;
			optOutKeywordWriter.updateKeywordFrequency(frequency, optOutKeyword);
		} else {
			optOutKeywordWriter.addToOptKeywordList(optOutKeyword, BASE_OCCURRANCE);
		}
	}

	@RequestMapping(value = "/getBlackListQueries", method = RequestMethod.GET)
	public List<String> getKeywordList() {
		List<String> blackList = blackListKeywordReader.readBlackListKeyword();
		return blackList;
	}

	@RequestMapping("/writeToBlackList")
	public void writeBlackList() {
		blackListKeywordReader.writeBlackListKeywords();
	}

}
