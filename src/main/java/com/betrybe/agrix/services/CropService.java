package com.betrybe.agrix.services;

import com.betrybe.agrix.controllers.dto.CropCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entity.Crop;
import com.betrybe.agrix.models.entity.Farm;
import com.betrybe.agrix.models.entity.Fertilizer;
import com.betrybe.agrix.models.repository.CropRepository;
import com.betrybe.agrix.models.repository.FarmRepository;
import com.betrybe.agrix.models.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The CropService class provides business logic for managing crop-related operations.
 * This service is responsible for inserting new crops into the database and performing validations.
 * It interacts with the CropRepository and FarmRepository to access and persist crop data.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-11
 */
@Service
public class CropService {

  /**
   * The repository for managing crop data.
   */
  private final CropRepository cropRepository;

  /**
   * The repository for managing farm data.
   */
  private final FarmRepository farmRepository;

  /**
   * The repository for managing fertilizer data.
   */
  private final FertilizerRepository fertilizerRepository;

  /**
   * Constructs a new CropService with the given crop and farm repositories.
   *
   * @param cropRepository The repository for managing crop data.
   * @param farmRepository The repository for managing farm data.
   */
  @Autowired
  public CropService(CropRepository cropRepository,
      FarmRepository farmRepository,
      FertilizerRepository fertilizerRepository
  ) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Inserts a new crop into the database.
   *
   * @param farmId   The ID of the farm to which the crop belongs.
   * @param cropDto  The DTO containing information for creating the crop.
   * @return The newly inserted crop entity.
   * @throws NotFoundException If the specified farm ID is not found in the database.
   */
  public Crop insertCrop(Long farmId, CropCreationDto cropDto) throws NotFoundException {
    Optional<Farm> farmOptional = farmRepository.findById(farmId);
    farmOptional.orElseThrow(() -> new NotFoundException("Fazenda não encontrada!"));

    Crop newCrop = new Crop();
    newCrop.setFarm(farmOptional.get());
    newCrop.setName(cropDto.name());
    newCrop.setPlantedArea(cropDto.plantedArea());
    newCrop.setPlantingDate(cropDto.plantedDate());
    newCrop.setHarvestDate(cropDto.harvestDate());

    return cropRepository.save(newCrop);
  }

  /**
   * Retrieves a list of crops associated with a specific farm.
   *
   * @param farmId The ID of the farm.
   * @return A list of crops associated with the specified farm.
   * @throws NotFoundException If no crops are found for the specified farm.
   */
  public List<Crop> findByFarmId(Long farmId) throws NotFoundException {
    Optional.ofNullable(farmRepository.findById(farmId)
        .orElseThrow(() -> new NotFoundException("Fazenda não encontrada!")));

    List<Crop> allCrop = cropRepository.findAll();

    List<Crop> cropsForFarm = allCrop.stream()
        .filter(crop -> crop.getFarm().getId().equals(farmId))
        .collect(Collectors.toList());

    return cropsForFarm;
  }

  /**
   * Retrieves a list of all crops in the database.
   *
   * @return A list of all crops.
   */
  public List<Crop> allcrop() {
    List<Crop> allCrop = cropRepository.findAll();
    return allCrop;
  }

  /**
   * Retrieves a specific crop by its ID.
   *
   * @param cropId The ID of the crop.
   * @return The retrieved crop entity.
   * @throws NotFoundException If the specified crop ID is not found in the database.
   */
  public Crop getByIdCrop(Long cropId) throws NotFoundException {
    Optional<Crop> cropOptional = cropRepository.findById(cropId);
    cropOptional.orElseThrow(() -> new NotFoundException("Plantação não encontrada!"));
    return cropOptional.get();
  }

  /**
   * Get all crops in a specified time range.
   *
   * @param startDate the lower limit.
   * @param endDate the upper limit.
   * @return A list of crops.
   */
  public List<Crop> serchCropByHarvestDate(LocalDate startDate, LocalDate endDate) {
    List<Crop> getCrops = cropRepository.findByHarvestDateBetween(startDate, endDate);
    return getCrops;
  }

  /**
   * Associates a fertilizer with a crop.
   *
   * @param cropId The ID of the crop to which the fertilizer will be associated.
   * @param fertilizerId The ID of the fertilizer to be associated with the crop.
   * @return A message indicating the successful association of the fertilizer and crop.
   * @throws NotFoundException If either the specified crop ID or fertilizer ID is not
   *     found in the database.
   */
  public String associatedPost(Long cropId, Long fertilizerId) throws NotFoundException {
    Optional<Crop> getCropId = cropRepository.findById(cropId);
    if (getCropId.isEmpty()) {
      throw new NotFoundException("Plantação não encontrada!");
    }

    Optional<Fertilizer> getFertilizerId = fertilizerRepository.findById(fertilizerId);
    if (getFertilizerId.isEmpty()) {
      throw new NotFoundException("Fertilizante não encontrado!");
    }

    Crop crop = getCropId.get();
    Fertilizer fertilizer = getFertilizerId.get();

    crop.getFertilizerList().add(fertilizer);
    fertilizer.getCrops().add(crop);

    fertilizerRepository.save(fertilizer);
    cropRepository.save(crop);

    return "Fertilizante e plantação associados com sucesso!";
  }



}