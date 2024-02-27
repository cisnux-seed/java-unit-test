package dev.cisnux.unittest.service;

import dev.cisnux.unittest.data.Person;
import dev.cisnux.unittest.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;
    private PersonService service;

    @BeforeEach
    void setUp() {
        service = new PersonService(repository);
    }

    @Test
    public void testGetPersonById_WhenNotFound() {
        final var expectedPerson = new Person("1", "Fajra Risqulla");
        assertThrows(IllegalArgumentException.class, () -> service.get(expectedPerson.id()));
    }

    @Test
    public void testGetPersonById_WhenSuccess() {
        // arrange
        final var expectedPerson = new Person("1", "Fajra Risqulla");

        // stubbing
        when(repository.selectPersonById(expectedPerson.id())).thenReturn(expectedPerson);

        // act
        final var actualPerson = service.get(expectedPerson.id());

        // assert
        assertNotNull(actualPerson);
        assertEquals(expectedPerson.id(), actualPerson.id());
        assertEquals(expectedPerson.name(), actualPerson.name());
    }

    @Test
    void testRegister_WhenSuccess() {
        // arrange
        final var dummyName = "Fajra Risqulla";

        // act
        final var actualPerson = service.register(dummyName);

        // assert
        assertNotNull(actualPerson);
        assertNotNull(actualPerson.id());
        assertEquals(dummyName, actualPerson.name());

        // spying
        verify(repository, times(1)).insert(new Person(actualPerson.id(), dummyName));
    }
}