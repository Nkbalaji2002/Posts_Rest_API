package com.example.api.restdemo.controller;

import com.example.api.restdemo.model.Person;
import com.example.api.restdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllController() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Optional<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return personService.updatePerson(id, personDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/page")
    public Page<Person> getPersonsPage(@RequestParam int page, @RequestParam int size) {
        return personService.getPersonsPage(page, size);
    }

    @GetMapping("/page/sorted")
    public Page<Person> getPersonsPageSorted(@RequestParam int page, @RequestParam int size, @RequestParam String SortBy) {
        return personService.getPersonPageSorted(page, size, SortBy);
    }
}
