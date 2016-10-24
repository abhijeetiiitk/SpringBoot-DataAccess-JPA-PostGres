package com.tgt.search.microservices.blackList.processor;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tgt.search.microservices.blackList.model.OptOutKeywordEntity;

@Resource
public interface OptOutRepository extends CrudRepository<OptOutKeywordEntity, Long> {

	static final String READ_BLACKLIST_ELIGIBLE_KEYWORDS_QUERY = "SELECT optOutKeyword FROM OptOutKeywordEntity WHERE keywordFrequency*100/:thresholdValue > :blackListEligiblePercentage AND optOutKeyword NOT IN (SELECT blackListKeyword FROM BlackListKeywordEntity)";
	final static String IS_KEYWORD_EXIST = "SELECT COUNT(OptOutKeywordEntity) FROM OptOutKeywordEntity WHERE optOutKeyword = :optOutKeyword)";
	final static String UPDATE_KEYWORD_FREQUENCY = "UPDATE OptOutKeywordEntity SET keywordFrequency = :keywordFrequency,updatedTime= now() WHERE optOutKeyword = :optOutKeyword)";

	@Query(READ_BLACKLIST_ELIGIBLE_KEYWORDS_QUERY)
	public List<String> findBlackListElegibleKeyword(@Param("thresholdValue") int thresholdValue,
			@Param("blackListEligiblePercentage") int blackListEligiblePercentage);

	@Query(IS_KEYWORD_EXIST)
	public Long exist(@Param("optOutKeyword") String optOutKeyword);

	@Transactional
	@Modifying
	@Query(UPDATE_KEYWORD_FREQUENCY)
	public void updateKeywordFrequency(@Param("keywordFrequency") int keywordFrequency,
			@Param("optOutKeyword") String optOutKeyword);

	@Query
	public OptOutKeywordEntity findByOptOutKeyword(String optOutKeyword);

}
