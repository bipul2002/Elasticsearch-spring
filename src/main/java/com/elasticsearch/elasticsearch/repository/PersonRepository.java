package com.elasticsearch.elasticsearch.repository;

import com.elasticsearch.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person,String> {
}
