package com.betrybe.agrix.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Farm class represents a farm in the Agrix application.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
@Entity
@Table(name = "farm")
public class Farm {

  /**
   * The unique identifier of the farm.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The name of the farm.
   */
  private String name;

  /**
   * The size of the farm in square meters.
   */
  private Double size;

  /**
   * Constructs a new Farm with no id, name, or size.
   */
  public Farm() {}

  /**
   * Constructs a new Farm with the given id, name, and size.
   *
   * @param id The id of the farm.
   * @param name The name of the farm.
   * @param size The size of the farm in square meters.
   */
  public Farm(Long id, String name, Double size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  /**
   * Gets the id of the farm.
   *
   * @return The id of the farm.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id of the farm.
   *
   * @param id The new id of the farm.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name of the farm.
   *
   * @return The name of the farm.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the farm.
   *
   * @param name The new name of the farm.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the size of the farm in square meters.
   *
   * @return The size of the farm in square meters.
   */
  public Double getSize() {
    return size;
  }

  /**
   * Sets the size of the farm in square meters.
   *
   * @param size The new size of the farm in square meters.
   */
  public void setSize(Double size) {
    this.size = size;
  }
}