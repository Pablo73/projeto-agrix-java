package com.betrybe.agrix.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * The Fertilizer class represents a fertilizer entity in the Agrix application.
 * It defines the properties and relationships of a fertilizer.
 * Fertilizers can be associated with multiple crops.
 *
 * <p>This class is an entity mapped to the "fertilizer" table in the database.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String brand;

  private String composition;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "fertilizer_id"),
      inverseJoinColumns = @JoinColumn(name = "crop_id")
  )
  private List<Crop> crops;

  /**
   * Default constructor for the Fertilizer class.
   */
  public Fertilizer() {
  }

  /**
   * Constructor for the Fertilizer class.
   *
   * @param id          The unique identifier of the fertilizer.
   * @param name        The name of the fertilizer.
   * @param brand       The brand of the fertilizer.
   * @param composition The composition of the fertilizer.
   */
  public Fertilizer(Long id, String name, String brand, String composition) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
  }

  /**
   * Get the unique identifier of the fertilizer.
   *
   * @return The unique identifier of the fertilizer.
   */
  public Long getId() {
    return id;
  }

  /**
   * Set the unique identifier of the fertilizer.
   *
   * @param id The unique identifier to set.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get the name of the fertilizer.
   *
   * @return The name of the fertilizer.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the fertilizer.
   *
   * @param name The name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the brand of the fertilizer.
   *
   * @return The brand of the fertilizer.
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Set the brand of the fertilizer.
   *
   * @param brand The brand to set.
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * Get the composition of the fertilizer.
   *
   * @return The composition of the fertilizer.
   */
  public String getComposition() {
    return composition;
  }

  /**
   * Set the composition of the fertilizer.
   *
   * @param composition The composition to set.
   */
  public void setComposition(String composition) {
    this.composition = composition;
  }

  /**
   * Get the list of crops associated with the fertilizer.
   *
   * @return The list of crops associated with the fertilizer.
   */
  public List<Crop> getCrops() {
    return crops;
  }

  /**
   * Set the list of crops associated with the fertilizer.
   *
   * @param crops The list of crops to set.
   */
  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}