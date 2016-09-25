package com.tgt.search.microservices.blackList.processor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tgt.search.microservices.blackList.model.BlackListKeywordEntity;

@Service
public interface BlackListRepository extends CrudRepository<BlackListKeywordEntity, Long> {
}
