package com.betrybe.agrix;


import com.betrybe.agrix.models.entity.Person;
import com.betrybe.agrix.models.repository.PersonRepository;
import com.betrybe.agrix.security.Role;
import com.betrybe.agrix.services.PersonService;
import java.util.Optional;
import com.betrybe.agrix.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringJUnitConfig(PersonService.class)
@SpringBootTest
public class PersonServiceTest {
  @MockBean
  private PersonRepository personRepository;

  @Autowired
  private PersonService personService;

  @Test
  public void TestCreate() {

    Person person = new Person();
    person.setUsername("Madre Teresa de Calcutá");
    person.setPassword("111111");
    person.setRole(Role.ADMIN);

    Person personReturn = new Person();
    personReturn.setId(676L);
    personReturn.setUsername(person.getUsername());
    personReturn.setPassword(person.getPassword());
    personReturn.setRole(person.getRole());

    when(personRepository.save(any(Person.class))).thenReturn(personReturn);

    Person savedPerson = personRepository.save(person);

    verify(personRepository, times(1)).save(any(Person.class));

    assertNotNull(savedPerson);
    assertEquals(person.getPassword(), savedPerson.getPassword());
  }

  @Test
  public void TestGetPersonByUsername() {

    Person person = new Person();
    person.setUsername("Madre Teresa de Calcutá");
    person.setPassword("111111");
    person.setRole(Role.ADMIN);

    Person personReturn = new Person();
    personReturn.setId(676L);
    personReturn.setUsername(person.getUsername());
    personReturn.setPassword(person.getPassword());
    personReturn.setRole(person.getRole());

    when(personRepository.findByUsername(any(String.class))).thenReturn(personReturn);

    Person getPersonByUserName = personRepository.findByUsername("Madre Teresa de Calcutá");

    verify(personRepository, times(1)).findByUsername(any(String.class));

    assertEquals(personReturn, getPersonByUserName);
  }

  @Test
  public void TestGetPersonById() {

    Person person = new Person();
    person.setUsername("Madre Teresa de Calcutá");
    person.setPassword("111111");
    person.setRole(Role.ADMIN);

    Person personReturn = new Person();
    personReturn.setId(676L);
    personReturn.setUsername(person.getUsername());
    personReturn.setPassword(person.getPassword());
    personReturn.setRole(person.getRole());

    when(personRepository.findById(any(Long.class))).thenReturn(Optional.of(personReturn));

    Optional<Person> getPersonById = personRepository.findById(676L);

    verify(personRepository, times(1)).findById(676L);

    assertEquals(personReturn, getPersonById.get());
  }

  @Test
  public void testGetPersonByIdIsEmpty() {
    when(personRepository.findById(any(Long.class))).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> personService.getPersonById(112L));

    verify(personRepository).findById(112L);
  }


  @Test
  public void TestGetPersonByUsernameIsEmpty() {
    when(personRepository.findByUsername(any(String.class))).thenReturn(null);

    assertThrows(NotFoundException.class, () -> personService.getPersonByUsername("Pedro"));

    verify(personRepository).findByUsername("Pedro");
  }

  @Test
  public void TestCreateInvalid() {

    Person person = new Person();
    person.setUsername("");
    person.setPassword("111111");
    person.setRole(Role.ADMIN);

    Person createdPerson = personService.create(person);
    assertNull(createdPerson);
  }

}