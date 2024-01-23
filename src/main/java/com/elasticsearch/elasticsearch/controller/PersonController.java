package com.elasticsearch.elasticsearch.controller;

import com.elasticsearch.elasticsearch.entity.Person;
import com.elasticsearch.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public Iterable<Person> findAllPerson()
    {
        return personService.findAll();
    }


    @PostMapping("/")
    public ResponseEntity<String> addAPerson(@RequestBody Person p)
    {
        personService.create(p);
        return  ResponseEntity.ok("Person is added");
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable("id") String id)
    {
        return personService.findById(id);
    }
}
