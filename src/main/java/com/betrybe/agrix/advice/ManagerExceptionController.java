package com.betrybe.agrix.advice;

import com.betrybe.agrix.exception.ErrorRequestException;
import com.betrybe.agrix.exception.ForbiddenException;
import com.betrybe.agrix.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Controller advice class for handling exceptions in the Agrix application.
 * This class is responsible for providing consistent error responses for
 * various types of exceptions.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */

@ControllerAdvice
public class ManagerExceptionController {

  /**
   * Exception handler method for handling NotFoundException.
   *
   * @param exception The NotFoundException that occurred.
   * @return A ResponseEntity with HTTP status code 404 (NOT FOUND)
   *     and the exception message in the response body.
   */

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFoundException(
      NotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  /**
   * Exception handler method for handling errorRequestException.
   *
   * @param exception The ErrorRequestException that occurred.
   * @return A ResponseEntity with HTTP status code.
   */
  @ExceptionHandler(ErrorRequestException.class)
  public ResponseEntity<String> handleErrorRequestException(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }

  /**
   * Exception handler method for handling forbiddenException.
   *
   * @param exception The ForbiddenException that occurred.
   * @return A ResponseEntity with HTTP status code.
   */
  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<String> handleForbiddenException(
      ForbiddenException exception) {
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(exception.getMessage());
  }

  /**
   * Exception handler method for handling Exception.
   *
   * @param exception The Exception that occurred.
   * @return A ResponseEntity with HTTP status code.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(exception.getMessage());
  }

  /**
   * Exception handler method for handling Throwable.
   *
   * @param exception The Throwable that occurred.
   * @return A ResponseEntity with HTTP status code.
   */
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_GATEWAY)
        .body(exception.getMessage());
  }
}