package com.betrybe.agrix.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.betrybe.agrix.models.entity.Person;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The TokenService class provides methods for generating and validating JWT tokens.
 * This service is responsible for handling token-related operations, including
 * token generation and validation.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  /**
   * Generates a JWT token for the given person.
   *
   * @param person The person for whom the token is generated.
   * @return The generated JWT token.
   */
  public String generateToken(Person person) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("trybetrack")
        .withSubject(person.getUsername())
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);
  }

  /**
   * Generates the expiration date for the JWT token.
   *
   * @return The expiration date of the JWT token.
   */
  private Instant generateExpirationDate() {
    return LocalDateTime.now()
        .plusHours(2)
        .toInstant(ZoneOffset.of("-03:00"));
  }

  /**
   * Validates a JWT token and retrieves the subject (username) from it.
   *
   * @param token The JWT token to be validated.
   * @return The subject (username) retrieved from the validated token.
   */
  public String validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.require(algorithm)
        .withIssuer("trybetrack")
        .build()
        .verify(token)
        .getSubject();
  }

}
