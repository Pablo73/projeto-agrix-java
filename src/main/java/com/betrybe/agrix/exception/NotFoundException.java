package com.betrybe.agrix.exception;

/**
 * Custom exception class for representing a farm not found.
 * This exception is typically thrown when a requested farm is not found in the system.
 * Extends the {@link RuntimeException} class, making it an unchecked exception.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
public class NotFoundException extends RuntimeException {

  /**
   * Constructs a new {@code NotFoundException} with a default error message.
   *
   * @param message Custom message describing the details of the exception.
   */
  public NotFoundException(String message) {
    super(message);
  }

  /**
   * Constructs a new {@code NotFoundException} with no message.
   * This constructor can be used when a specific error message is not needed.
   */
  public NotFoundException() {
    super();
  }

}