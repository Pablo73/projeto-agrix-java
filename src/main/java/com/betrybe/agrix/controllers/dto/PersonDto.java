package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.security.Role;

/**
 * Data transfer object (DTO) representing a person.
 * This DTO holds information about a person, including their ID, username, and role.
 *
 * @since 2023-08-17
 */
public record PersonDto(
    Long id,
    String username,
    String role
) {

}
