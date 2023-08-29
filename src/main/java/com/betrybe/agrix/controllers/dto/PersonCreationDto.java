package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entity.Person;
import jakarta.validation.constraints.NotNull;

/**
 * The PersonCreationDto class is a data transfer object for Person.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
public record PersonCreationDto(
    Long id,
    @NotNull String username,
    @NotNull String password,
    @NotNull String role
) {
  public Person toPerson() {
    return new Person(id, username, password, role);
  }
}
