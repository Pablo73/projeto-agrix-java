package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entity.Farm;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * The CropDto class is a data transfer object for crop.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */

public record CropCreationDto(
    Long id,
    Farm farm,
    @NotBlank String name,
    @NotNull Double plantedArea,
    @NotNull LocalDate plantedDate,
    @NotNull LocalDate harvestDate
) {}