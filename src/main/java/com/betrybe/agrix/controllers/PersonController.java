package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.exception.ErrorRequestException;
import com.betrybe.agrix.models.entity.Person;
import com.betrybe.agrix.services.PersonService;
import com.betrybe.agrix.util.DtoConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The PersonController class provides a REST API for managing person-related operations.
 * This controller handles operations related to creating persons.
 * The API endpoints are designed to follow RESTful conventions.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@RestController
@RequestMapping(value = "persons")
public class PersonController {

  /**
   * The person service used for managing person-related operations.
   */
  private final PersonService personService;

  /**
   * Constructs a new PersonController with the given person service.
   *
   * @param personService The person service to be injected into the controller.
   */
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Creates a new person.
   *
   * @param personCreationDto The person creation data transfer object containing information
   *                          for creating the person.
   * @return A ResponseEntity with the created person's data and an HTTP status
   *         code of 201 (CREATED).
   */
  @PostMapping
  public ResponseEntity<?> createPerson(@RequestBody @Valid PersonCreationDto personCreationDto) {
    try {
      Person createPerson = personService.create(personCreationDto.toPerson());

      DtoConverter dtoConverter = new DtoConverter();
      PersonDto personDto = dtoConverter.personToDto(createPerson);

      return ResponseEntity.status(HttpStatus.CREATED).body(personDto);

    } catch (ErrorRequestException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
