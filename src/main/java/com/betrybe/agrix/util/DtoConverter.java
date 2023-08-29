package com.betrybe.agrix.util;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.models.entity.Crop;
import com.betrybe.agrix.models.entity.Fertilizer;
import com.betrybe.agrix.models.entity.Person;

/**
 * The DtoConverter class provides utility methods for converting entity
 *     objects to DTOs.
 * This class contains static methods for converting Crop and Fertilizer
 *     entities to their respective DTOs.
 *
 * <p>This utility class facilitates the conversion of entity objects to DTOs
 *     for API responses.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-11
 */
public class DtoConverter {

  /**
   * Converts a Crop entity to a CropNewDto.
   *
   * @param crop The Crop entity to be converted.
   * @return The corresponding CropNewDto.
   */
  public static CropDto cropToDto(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarmId(),
        crop.getPlantingDate(),
        crop.getHarvestDate()
    );
  }

  /**
   * Converts a Fertilizer entity to a FertilizerNewDto.
   *
   * @param fertilizer The Fertilizer entity to be converted.
   * @return The corresponding FertilizerNewDto.
   */
  public static FertilizerDto fertilizerToDto(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  /**
   * Converts a Person entity to a PersonDto.
   *
   * @param person The Person entity to be converted.
   * @return The corresponding PersonDto.
   */
  public static PersonDto personToDto(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }
}