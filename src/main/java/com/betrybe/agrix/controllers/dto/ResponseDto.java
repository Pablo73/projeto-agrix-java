package com.betrybe.agrix.controllers.dto;

/**
 * A generic response data transfer object (DTO) class that encapsulates a single piece of data.
 * This class is commonly used to wrap responses containing a single value or token.
 *
 * @param <T> The type of data to be encapsulated.
 */
public record ResponseDto<T>(T token) {}
