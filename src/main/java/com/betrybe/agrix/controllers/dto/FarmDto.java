package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entity.Farm;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * The FarmDto class is a data transfer object for farms.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
public record FarmDto(Long id, @NotBlank String name, @NotNull Double size) {

  /**
   * Converts this DTO to a Farm entity.
   *
   * @return The Farm entity.
   */
  public Farm toFarm() {
    return new Farm(id, name, size);
  }

}