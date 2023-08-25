package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.controllers.dto.FertilizerNewDto;
import com.betrybe.agrix.exception.ErrorRequestException;
import com.betrybe.agrix.models.entity.Crop;
import com.betrybe.agrix.models.entity.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import com.betrybe.agrix.util.DtoConverter;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The FertilizerController class provides a REST API for managing fertilizers.
 * This controller handles operations related to creating fertilizers.
 * The API endpoints are designed to follow RESTful conventions.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@RestController
@RequestMapping
public class FertilizerController {

  /**
   * The fertilizer service used for managing fertilizer-related operations.
   */
  private final FertilizerService fertilizerService;

  /**
   * Constructs a new FertilizerController with the given fertilizer service.
   *
   * @param fertilizerService The fertilizer service to be injected into the controller.
   */
  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Creates a new fertilizer.
   *
   * @param fertilizerDto The fertilizer data transfer object containing information
   *                      for creating the fertilizer.
   * @return A ResponseEntity with the created fertilizer's data and an HTTP status
   *     code of 201 (CREATED).
   */
  @PostMapping("fertilizers")
  public ResponseEntity<?> createFertilizer(@RequestBody @Valid FertilizerDto fertilizerDto) {
    try {
      Fertilizer newFertilizer = fertilizerService.insertFertilizer(fertilizerDto.toFertilizer());

      DtoConverter dtoConverter = new DtoConverter();
      FertilizerNewDto fertilizerNewDto = dtoConverter.fertilizerToDto(newFertilizer);

      return ResponseEntity.status(HttpStatus.CREATED).body(fertilizerNewDto);

    } catch (ErrorRequestException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  /**
   * Creates a list of all fertilizers.
   *
   * @return The list of FertilizerNewDto.
   */

  @GetMapping("fertilizers")
  public ResponseEntity<List<FertilizerNewDto>> getAllFertilizer() {
    List<Fertilizer> allFertilizer = fertilizerService.getAllFertilizer();

    DtoConverter dtoConverter = new DtoConverter();

    List<FertilizerNewDto> listFertilizer = allFertilizer.stream()
        .map(fertilizer -> dtoConverter.fertilizerToDto(fertilizer))
        .collect(Collectors.toList());

    return ResponseEntity.ok(listFertilizer);
  }

  /**
   * Retrieve details of a specific fertilizer using its ID.
   *
   * @param fertilizerId The unique identifier of the fertilizer.
   * @return A ResponseEntity containing details of the requested fertilizer.
   */
  @GetMapping("fertilizers/{fertilizerId}")
  public ResponseEntity<FertilizerNewDto> findByFertilizerId(@PathVariable Long fertilizerId) {
    Fertilizer byFertilizerId = fertilizerService.findByFertilizerId(fertilizerId);

    DtoConverter dtoConverter = new DtoConverter();
    FertilizerNewDto fertilizer = dtoConverter.fertilizerToDto(byFertilizerId);

    return ResponseEntity.ok(fertilizer);

  }

  /**
   * Retrieves a list of fertilizers associated with a specific crop.
   *
   * @param cropId The ID of the crop.
   * @return A ResponseEntity containing a list of FertilizerNewDto objects
   *     associated with the crop.
   */
  @GetMapping("crops/{cropId}/fertilizers")
  public ResponseEntity<List<FertilizerNewDto>> findByAssociationFertilizer(
      @PathVariable Long cropId) {
    List<Fertilizer> fertilizers = fertilizerService.findByAssociationFertilizer(cropId);

    DtoConverter dtoConverter = new DtoConverter();

    List<FertilizerNewDto> listFertilizer = fertilizers.stream()
        .map(fertilizer -> dtoConverter.fertilizerToDto(fertilizer))
        .collect(Collectors.toList());

    return ResponseEntity.ok(listFertilizer);
  }
}