package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.PersonNotFoundException;
import com.betrybe.agrix.models.entity.Person;
import com.betrybe.agrix.models.repository.PersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service layer class for handling persons business logic.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-25
 */
@Service
public class PersonService {

  private final PersonRepository personRepository;

  /**
   * Constructs a new PersonService with the given person repository.
   *
   * @param personRepository The repository for managing person data.
   */
  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  /**
   * Returns a person for a given ID.
   *
   * @param id The unique identifier of the person.
   * @return The retrieved person entity.
   * @throws PersonNotFoundException If the specified person ID is not found in the database.
   */
  public Person getPersonById(Long id) {
    Optional<Person> person = personRepository.findById(id);

    if (person.isEmpty()) {
      throw new PersonNotFoundException();
    }

    return person.get();
  }

  /**
   * Returns a person for a given username.
   *
   * @param username The username associated with the person.
   * @return The retrieved person entity.
   * @throws PersonNotFoundException If the specified username is not found in the database.
   */
  public Person getPersonByUsername(String username) {
    Optional<Person> person = personRepository.findByUsername(username);

    if (person.isEmpty()) {
      throw new PersonNotFoundException();
    }

    return person.get();
  }

  /**
   * Creates a new person.
   *
   * @param person The person entity to be created.
   * @return The created person entity.
   */
  public Person create(Person person) {
    String hashedPassword = new BCryptPasswordEncoder().encode(person.getPassword());

    Person newPerson = new Person();
    newPerson.setUsername(person.getUsername());
    newPerson.setPassword(hashedPassword);
    newPerson.setRole(person.getRole());

    return personRepository.save(newPerson);
  }
}