package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entity.Fertilizer;
import jakarta.validation.constraints.NotBlank;

/**
 * The FertilizerDto class is a data transfer object representing fertilizer data.
 * This class is used for receiving and sending fertilizer-related data through the API.
 * It contains fields representing the attributes of a fertilizer.
 *
 * <p>This class uses the record feature introduced in Java 16.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
public record FertilizerCreationDto(
    @NotBlank String name,
    @NotBlank String brand,
    @NotBlank String composition
) {
}
