package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.AuthenticationDto;
import com.betrybe.agrix.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.controllers.dto.ResponseDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entity.Person;
import com.betrybe.agrix.services.PersonService;
import com.betrybe.agrix.services.TokenService;
import com.betrybe.agrix.util.DtoConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

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
@RequestMapping
public class PersonController {

  private final AuthenticationManager authenticationManager;

  private final TokenService tokenService;

  private final PersonService personService;

  /**
   * Constructs a new PersonController with the given person service.
   *
   * @param authenticationManager The authentication manager to handle user authentication.
   * @param tokenService           The token service for generating and validating tokens.
   * @param personService         The person service to be injected into the controller.
   */
  @Autowired
  public PersonController(AuthenticationManager authenticationManager, TokenService tokenService,
      PersonService personService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
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
  @PostMapping("/persons")
  public ResponseEntity<?> createPerson(@RequestBody @Valid PersonCreationDto personCreationDto) {
    Person createPerson = personService.create(personCreationDto.toPerson());

    DtoConverter dtoConverter = new DtoConverter();
    PersonDto personDto = dtoConverter.personToDto(createPerson);

    return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
  }


  /**
   * Handles user login authentication.
   *
   * @param authenticationDto The authentication data transfer object containing
   *                          the username and password.
   * @return A ResponseEntity containing the generated authentication token upon successful login,
   *         or a status of HttpStatus.FORBIDDEN if authentication fails.
   */
  @PostMapping("/auth/login")
  public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDto authenticationDto) {

    try {
      UsernamePasswordAuthenticationToken usernamePassword =
          new UsernamePasswordAuthenticationToken(
              authenticationDto.username(),
              authenticationDto.password()
          );

      Authentication auth = authenticationManager.authenticate(usernamePassword);

      Person person = (Person) auth.getPrincipal();

      String token = tokenService.generateToken(person);

      ResponseDto<String> response = new ResponseDto<>(token);

      return ResponseEntity.status(HttpStatus.OK).body(response);

    } catch (BadCredentialsException e) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha não autorizada!");

    } catch (InternalAuthenticationServiceException e) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário não autorizado!");
    }


    //    try {
    //      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //      Person person = personService.getPersonByUsername(authenticationDto.username());
    //
    //      if (passwordEncoder.matches(authenticationDto.password(), person.getPassword())) {
    //        String token = tokenService.generateToken(person);
    //        ResponseDto<String> response = new ResponseDto<>(token);
    //        return ResponseEntity.status(HttpStatus.OK).body(response);
    //      } else {
    //        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha não autorizada");
    //      }
    //    } catch (NotFoundException e) {
    //        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário não autorizado");
    //    }
  }
}
