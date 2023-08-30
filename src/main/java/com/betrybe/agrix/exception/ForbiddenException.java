package com.betrybe.agrix.exception;

/**
 * Custom exception class for representing a 403 Forbidden error.
 * This exception is typically thrown when a user is not authorized to access a resource.
 * Extends the {@link RuntimeException} class, making it an unchecked exception.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
public class ForbiddenException extends RuntimeException {

  /**
   * Constructs a new {@code ForbiddenException} with a default error message.
   *
   * @param message Custom message describing the details of the exception.
   */
  public ForbiddenException(String message) {
    super(message);
  }

  /**
   * Constructs a new {@code ForbiddenException} with no message.
   * This constructor can be used when a specific error message is not needed.
   */
  public ForbiddenException() {
    super();
  }

}

