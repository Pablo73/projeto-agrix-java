package com.betrybe.agrix.controllers.dto;

import java.time.LocalDate;

/**
 * The CropNewDto.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */

public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId,
    LocalDate plantedDate,
    LocalDate harvestDate
) {}