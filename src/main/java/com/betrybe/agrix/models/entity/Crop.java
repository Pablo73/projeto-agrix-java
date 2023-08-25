package com.betrybe.agrix.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;


/**
 * The Crop class represents a crop entity in the Agrix application.
 * It defines the properties and relationships of a crop on a farm.
 * Crops are associated with farms and can have a planted area.
 *
 * <p>This class is an entity mapped to the "crop" table in the database.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-11
 */
@Entity
@Table(name = "crop")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  @JsonIgnore
  private Farm farm;

  private String name;

  private Double plantedArea;

  private LocalDate plantingDate;

  private LocalDate harvestDate;

  @ManyToMany(mappedBy = "crops")
  @JsonIgnore
  private List<Fertilizer> fertilizerList;

  /**
   * Default constructor for the Crop class.
   */
  public Crop() {
  }

  /**
   * Constructor for the Crop class.
   *
   * @param id           The unique identifier of the crop.
   * @param farm         The farm associated with the crop.
   * @param name         The name of the crop.
   * @param plantedArea  The planted area of the crop.
   * @param plantingDate The planting date.
   * @param harvestDate  The harvest date.
   */
  public Crop(Long id, Farm farm, String name, Double plantedArea, LocalDate plantingDate,
      LocalDate harvestDate) {
    this.id = id;
    this.farm = farm;
    this.name = name;
    this.plantedArea = plantedArea;
    this.plantingDate = plantingDate;
    this.harvestDate = harvestDate;
  }

  /**
   * Get the unique identifier of the crop.
   *
   * @return The unique identifier of the crop.
   */
  public Long getId() {
    return id;
  }

  /**
   * Set the unique identifier of the crop.
   *
   * @param id The unique identifier to set.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get the farm associated with the crop.
   *
   * @return The farm associated with the crop.
   */
  public Farm getFarm() {
    return farm;
  }

  /**
   * Set the farm associated with the crop.
   *
   * @param farm The farm to set.
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  /**
   * Get the name of the crop.
   *
   * @return The name of the crop.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the crop.
   *
   * @param name The name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the planted area of the crop.
   *
   * @return The planted area of the crop.
   */
  public Double getPlantedArea() {
    return plantedArea;
  }

  /**
   * Set the planted area of the crop.
   *
   * @param plantedArea The planted area to set.
   */
  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Get the ID of the associated farm.
   *
   * @return The ID of the associated farm.
   */
  public Long getFarmId() {
    return farm.getId();
  }

  /**
   * Get the planting date.
   *
   * @return The planting date.
   */
  public LocalDate getPlantingDate() {
    return plantingDate;
  }

  /**
   * Set the planting date.
   *
   * @param plantingDate The planting date to set.
   */
  public void setPlantingDate(LocalDate plantingDate) {
    this.plantingDate = plantingDate;
  }

  /**
   * Get the harvest date.
   *
   * @return The harvest date.
   */
  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  /**
   * Set the harvest date.
   *
   * @param harvestDate The harvest date to set.
   */
  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  /**
   * Get the list of fertilizers associated with the crop.
   *
   * @return The list of fertilizers associated with the crop.
   */
  public List<Fertilizer> getFertilizerList() {
    return fertilizerList;
  }

  /**
   * Set the list of fertilizers associated with the crop.
   *
   * @param fertilizerList The list of fertilizers to set.
   */
  public void setFertilizerList(List<Fertilizer> fertilizerList) {
    this.fertilizerList = fertilizerList;
  }
}