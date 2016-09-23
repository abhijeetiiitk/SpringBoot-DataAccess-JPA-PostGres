package com.tgt.search.microservices.blackList.processor;

import org.springframework.data.repository.CrudRepository;

import com.tgt.search.microservices.blackList.model.BlackListKeywordEntity;

public interface BlackListRepository extends CrudRepository<BlackListKeywordEntity, Long> {
}
