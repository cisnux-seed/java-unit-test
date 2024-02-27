package dev.cisnux.unittest.repository;

import dev.cisnux.unittest.data.Person;

public interface PersonRepository {
    Person selectPersonById(String id);

    void insert(Person person);
}
