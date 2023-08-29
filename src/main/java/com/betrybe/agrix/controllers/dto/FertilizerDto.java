package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entity.Fertilizer;

/**
 * The FertilizerNewDto class is a data transfer object representing new fertilizer data.
 * This class is used for sending fertilizer-related data through the API in responses.
 * It contains fields representing the attributes of a fertilizer.
 *
 * <p>This class is designed to hold new fertilizer data.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
public record FertilizerDto(
    Long id,
    String name,
    String brand,
    String composition
) {
  /**
   * Converts the FertilizerDto to a Fertilizer entity.
   *
   * @return The corresponding Fertilizer entity.
   */
  public Fertilizer toFertilizer() {
    return new Fertilizer(id, name, brand, composition);
  }

}