package com.betrybe.agrix.security;

import com.betrybe.agrix.models.entity.Person;
import com.betrybe.agrix.services.PersonService;
import com.betrybe.agrix.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Custom security filter responsible for intercepting and processing incoming HTTP requests.
 * This filter is used for token-based authentication and authorization purposes.
 *
 * <p>The filter extracts the authorization token from the request header, validates it,
 * retrieves user details from the token, and sets up the security context accordingly.</p>
 *
 * @since 2023-08-17
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final PersonService personService;

  /**
   * Constructs a new SecurityFilter with the required services.
   *
   * @param tokenService   The service responsible for token-related operations.
   * @param personService  The service for managing user-related operations.
   */
  @Autowired
  public SecurityFilter(TokenService tokenService, PersonService personService) {
    this.tokenService = tokenService;
    this.personService = personService;
  }

  /**
   * Process the incoming request and perform authentication and authorization checks.
   *
   * @param request       The incoming HTTP request.
   * @param response      The HTTP response.
   * @param filterChain   The filter chain for additional filters.
   * @throws IOException      If an I/O error occurs during processing.
   * @throws ServletException If a servlet-related error occurs during processing.
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
    String token = recoveryToken(request);

    if (token != null) {
      String subject = tokenService.validateToken(token);
      Person userDetails = personService.getPersonByUsername(subject);

      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  /**
   * Retrieve the token from the request header.
   *
   * @param request The incoming HTTP request.
   * @return The extracted authorization token, or null if not present.
   */
  private String recoveryToken(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");
    if (authHeader == null) {
      return null;
    }
    return authHeader.replace("Bearer ", "");
  }
}
