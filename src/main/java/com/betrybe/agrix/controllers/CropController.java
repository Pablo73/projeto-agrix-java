package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropCreationDto;
import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entity.Crop;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.util.DtoConverter;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The CropController class provides a REST API for managing crops.
 * This controller handles operations related to creating, retrieving, and listing crops.
 * The API endpoints are designed to follow RESTful conventions.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
@RestController
@RequestMapping
public class CropController {

  /**
   * The crop service used for managing crop-related operations.
   */
  private final CropService cropService;

  /**
   * Constructs a new CropController with the given crop service.
   *
   * @param cropService The crop service to be injected into the controller.
   */
  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Creates a new crop.
   *
   * @param farmId  The unique identifier of the farm to which the crop belongs.
   * @param cropDto The crop data transfer object containing information for creating the crop.
   * @return A ResponseEntity with the created crop's data and an HTTP status code of 201 (CREATED).
   */
  @PostMapping("farms/{farmId}/crops")
  public ResponseEntity<CropDto> createCrop(
      @PathVariable Long farmId,
      @RequestBody @Valid CropCreationDto cropDto) {
    Crop newCrop = cropService.insertCrop(farmId, cropDto);

    DtoConverter dtoConverter = new DtoConverter();
    CropDto newCropDto = dtoConverter.cropToDto(newCrop);

    return ResponseEntity.status(HttpStatus.CREATED).body(newCropDto);
  }

  /**
   * Retrieves a list of crops associated with a specific farm.
   *
   * @param farmId The unique identifier of the farm.
   * @return A ResponseEntity containing a list of CropNewDto objects associated with the farm.
   */
  @GetMapping("farms/{farmId}/crops")
  public ResponseEntity<List<CropDto>> findByFarmId(@PathVariable Long farmId) {
    List<Crop> listFarmId = cropService.findByFarmId(farmId);

    DtoConverter dtoConverter = new DtoConverter();

    List<CropDto> cropDtos = listFarmId.stream()
        .map(crop -> dtoConverter.cropToDto(crop))
        .collect(Collectors.toList());

    return ResponseEntity.ok(cropDtos);
  }

  /**
   * Retrieves a list of all crops in the database.
   *
   * @return A ResponseEntity containing a list of CropNewDto objects for all crops.
   */
  @GetMapping("/crops")
  @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
  public ResponseEntity<List<CropDto>> findByFarmId() {
    List<Crop> listFarmId = cropService.allcrop();

    DtoConverter dtoConverter = new DtoConverter();

    List<CropDto> cropDtos = listFarmId.stream()
        .map(crop -> dtoConverter.cropToDto(crop))
        .collect(Collectors.toList());

    return ResponseEntity.ok(cropDtos);
  }

  /**
   * Retrieves details of a specific crop using its ID.
   *
   * @param id The unique identifier of the crop.
   * @return A ResponseEntity containing details of the requested crop.
   */
  @GetMapping("crops/{id}")
  public ResponseEntity<CropDto> findByCropId(@PathVariable Long id) {
    Crop cropId = cropService.getByIdCrop(id);

    DtoConverter dtoConverter = new DtoConverter();
    CropDto newCropDto = dtoConverter.cropToDto(cropId);

    return ResponseEntity.ok(newCropDto);
  }

  /**
   * Get all crops in a specified time range.
   *
   * @param startDate the lower limit.
   * @param endDate the upper limit.
   * @return A list of crops.
   */
  @GetMapping("crops/search")
  public ResponseEntity<List<CropDto>> serchCropByHarvestDate(
      @RequestParam("start") LocalDate startDate,
      @RequestParam("end") LocalDate endDate
  ) {
    List<Crop> listFarmId = cropService.serchCropByHarvestDate(startDate, endDate);

    DtoConverter dtoConverter = new DtoConverter();

    List<CropDto> cropDtos = listFarmId.stream()
        .map(crop -> dtoConverter.cropToDto(crop))
        .collect(Collectors.toList());

    return ResponseEntity.ok(cropDtos);
  }

  /**
   * Associates a fertilizer with a crop.
   *
   * @param cropId The ID of the crop to which the fertilizer will be associated.
   * @param fertilizerId The ID of the fertilizer to be associated with the crop.
   * @return A ResponseEntity with a success message and an HTTP status code of
   *     201 (CREATED).
   */
  @PostMapping("crops/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associatedPost(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    String associatedMessage = cropService.associatedPost(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED).body(associatedMessage);
  }

}