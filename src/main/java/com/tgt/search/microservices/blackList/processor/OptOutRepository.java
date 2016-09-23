package com.tgt.search.microservices.blackList.processor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tgt.search.microservices.blackList.model.OptOutKeywordEntity;

public interface OptOutRepository extends CrudRepository<OptOutKeywordEntity, Long>{
	
	static final String READ_BLACKLIST_ELIGIBLE_KEYWORDS_QUERY = "SELECT OPTOUT_QUERY FROM OPTOUT_KEYWORDS WHERE FREQUENCY*100/:thresholdValue > :blackListEligiblePercentage";
	
	final static String IS_KEYWORD_EXIST = "SELECT OPTOUT_QUERY FROM OPTOUT_KEYWORDS WHERE OPTOUT_QUERY = :optOutKeyword";
	
	@Query(READ_BLACKLIST_ELIGIBLE_KEYWORDS_QUERY)
    public List<String> findBlackListElegibleKeyword(@Param("thresholdValue")int thresholdValue, @Param("blackListEligiblePercentage")float blackListEligiblePercentage);
	
	@Query(IS_KEYWORD_EXIST)
	public String exist(@Param("optOutKeyword")String optOutKeyword);
	
	@Query
	public OptOutKeywordEntity findByOptOutKeyword(String optOutKeyword);
	
}
