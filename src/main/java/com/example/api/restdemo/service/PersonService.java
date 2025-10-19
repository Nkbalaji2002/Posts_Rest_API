package com.example.api.restdemo.service;

import com.example.api.restdemo.model.Person;
import com.example.api.restdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> updatePerson(Long id, Person personDetails) {
        return personRepository.findById(id).map(
                person -> {
                    person.setName(personDetails.getName());
                    person.setAge(personDetails.getAge());
                    return personRepository.save(person);
                }
        );
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Page<Person> getPersonsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return personRepository.findAll(pageable);
    }

    public Page<Person> getPersonPageSorted(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return personRepository.findAll(pageable);
    }

}
