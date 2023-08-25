package com.betrybe.agrix.models.repository;

import com.betrybe.agrix.models.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The FertilizerRepository interface provides methods for accessing
 *     fertilizer from the database.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}