package com.elasticsearch.elasticsearch.serviceImpl;

import com.elasticsearch.elasticsearch.entity.Person;
import com.elasticsearch.elasticsearch.repository.PersonRepository;
import com.elasticsearch.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public void create(Person p) {
        personRepository.save(p);
    }

    @Override
    public Person findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}
