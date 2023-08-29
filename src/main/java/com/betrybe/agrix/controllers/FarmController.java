package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.exception.ErrorRequestException;
import com.betrybe.agrix.models.entity.Farm;
import com.betrybe.agrix.services.FarmService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The FarmController class provides a REST API for managing farms.
 * This controller handles operations related to creating, retrieving, and listing farms.
 * The API endpoints are designed to be RESTful.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
@RestController
@RequestMapping(value = "farms")
public class FarmController {

  /**
   * The farm service.
   */
  private final FarmService farmService;

  /**
   * Constructs a new FarmController with the given farm service.
   *
   * @param farmService The farm service.
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Creates a new farm.
   *
   * @param farmDto The farm DTO to create.
   * @return A ResponseEntity with the created farm and an HTTP status code of 201 (CREATED).
   */
  @PostMapping()
  public ResponseEntity<?> createFarm(@RequestBody @Valid FarmDto farmDto) {
    try {
      Farm newFarm = farmService.insertFarm(farmDto.toFarm());
      return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
    } catch (ErrorRequestException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  /**
   * Get all farms.
   *
   * @return A list containing all farms.
   */
  @GetMapping()
  @PreAuthorize("hasAuthority('ADMIN', 'MANAGER', 'USER')")
  public List<Farm> getAllFarm() {
    List<Farm> allFarms = farmService.getAllFarm();
    return allFarms;
  }

  /**
   * Get a farm by its unique identifier.
   *
   * @param id The unique identifier of the farm to retrieve.
   * @return A ResponseEntity with the retrieved farm and an HTTP
   *     status code of 200 (OK), or a 404 (Not Found) response if the farm does not exist.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
    Optional<Farm> optionalFarm = farmService.getFarmById(id);

    if (optionalFarm.isPresent()) {
      return ResponseEntity.ok(optionalFarm.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}