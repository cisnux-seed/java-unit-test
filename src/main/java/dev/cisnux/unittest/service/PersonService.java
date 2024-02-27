package dev.cisnux.unittest.service;

import dev.cisnux.unittest.data.Person;
import dev.cisnux.unittest.repository.PersonRepository;

import java.util.Optional;
import java.util.UUID;

public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person get(String id) {
        final var person = repository.selectPersonById(id);
        return Optional.ofNullable(person).orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public Person register(String name) {
        final var person = new Person(UUID.randomUUID().toString(), name);
        repository.insert(person);
        return person;
    }
}
