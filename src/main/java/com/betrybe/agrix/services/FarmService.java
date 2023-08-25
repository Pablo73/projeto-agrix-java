package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entity.Farm;
import com.betrybe.agrix.models.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The FarmService class provides business logic for farms.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
@Service
public class FarmService {

  /**
   * The farm repository.
   */
  private final FarmRepository farmRepository;

  /**
   * Constructs a new FarmService with the given farm repository.
   *
   * @param farmRepository The farm repository.
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Inserts a new farm into the database.
   *
   * @param farm The farm to insert.
   * @return The inserted farm.
   */
  public Farm insertFarm(Farm farm) {

    return farmRepository.save(farm);
  }

  /**
   * Gets all farms from the database.
   *
   * @return A list with all farms.
   */

  public List<Farm> getAllFarm() {

    return farmRepository.findAll();
  }

  /**
   * Gets a farm by id from the database.
   *
   * @param id The id of the farm to get.
   * @return The farm with the given id, or an empty Optional if the farm does not exist.
   */

  public Optional<Farm> getFarmById(Long id) {
    return Optional.ofNullable(farmRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Fazenda não encontrada!")));
  }
}