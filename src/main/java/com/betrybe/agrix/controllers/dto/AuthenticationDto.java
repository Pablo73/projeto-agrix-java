package com.betrybe.agrix.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * The AuthenticationDTO class represents the data required for user authentication.
 * This DTO is used to transfer the username and password information from the client
 * to the authentication process on the server.
 * It is typically used in authentication-related API endpoints for user login.
 * The class is designed as a simple container to hold the authentication data.
 *
 * <p>The class uses the record feature introduced in Java 16 to create an immutable
 * and concise representation of the authentication data.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
public record AuthenticationDto(@NotNull String username, @NotNull String password) {}
