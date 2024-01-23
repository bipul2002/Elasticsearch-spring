package com.elasticsearch.elasticsearch.service;

import com.elasticsearch.elasticsearch.entity.Person;

public interface PersonService {

    void create(Person p);

    Person findById(String id);

    Iterable<Person> findAll();
}
