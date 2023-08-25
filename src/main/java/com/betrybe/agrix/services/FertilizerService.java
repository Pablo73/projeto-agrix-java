package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entity.Crop;
import com.betrybe.agrix.models.entity.Fertilizer;
import com.betrybe.agrix.models.repository.CropRepository;
import com.betrybe.agrix.models.repository.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The FertilizerService class provides business logic for managing fertilizer-related operations.
 * This service is responsible for inserting new fertilizers into the database.
 * It interacts with the FertilizerRepository to access and persist fertilizer data.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@Service
public class FertilizerService {

  /**
   * The repository for managing fertilizer data.
   */
  private final FertilizerRepository fertilizerRepository;

  /**
   * The repository for managing crop data.
   */
  private final CropRepository cropRepository;

  /**
   * Constructs a new FertilizerService with the given fertilizer repository.
   *
   * @param fertilizerRepository The repository for managing fertilizer data.
   * @param cropRepository The repository for managing crop data.
   */
  @Autowired
  public FertilizerService(
      FertilizerRepository fertilizerRepository,
      CropRepository cropRepository) {
    this.fertilizerRepository = fertilizerRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Inserts a new fertilizer into the database.
   *
   * @param fertilizer The fertilizer entity to be inserted.
   * @return The inserted fertilizer entity.
   */
  public Fertilizer insertFertilizer(Fertilizer fertilizer) {
    Fertilizer saved = fertilizerRepository.save(fertilizer);
    return saved;
  }

  /**
   * Get all fertilizer into the database.
   *
   * @return The list of all fertilizers.
   */
  public List<Fertilizer> getAllFertilizer() {
    List<Fertilizer> allFertilizer = fertilizerRepository.findAll();
    return allFertilizer;
  }

  /**
   * Get a fertilizer through the id.
   *
   * @param fertilizerId The id Fertilizer.
   * @return The retrieved fertilizer entity.
   * @throws NotFoundException If the specified crop ID is not found in the database.
   */
  public Fertilizer findByFertilizerId(Long fertilizerId) throws NotFoundException {
    Optional<Fertilizer> fertilizer = Optional.ofNullable(
        fertilizerRepository.findById(fertilizerId)
            .orElseThrow(() -> new NotFoundException("Fertilizante não encontrado!")));

    return fertilizer.get();
  }

  /**
   * Retrieves a list of fertilizers associated with a specific crop.
   *
   * @param cropId The ID of the crop.
   * @return A list of fertilizers associated with the specified crop.
   * @throws NotFoundException If the specified crop ID is not found in the database.
   */
  public List<Fertilizer> findByAssociationFertilizer(Long cropId) throws NotFoundException {
    Optional<Crop> cropValid = Optional.ofNullable(
        cropRepository.findById(cropId)
            .orElseThrow(() -> new NotFoundException("Plantação não encontrada!")));

    List<Fertilizer> fertilizerRepositoryAll = fertilizerRepository.findAll();
    List<Fertilizer> collect = fertilizerRepositoryAll.stream()
        .filter(fertilizer -> fertilizer.getCrops().stream()
            .anyMatch(crop -> crop.getId().equals(cropId)))
        .collect(Collectors.toList());
    return collect;
  }
}