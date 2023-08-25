package com.betrybe.agrix.models.repository;

import com.betrybe.agrix.models.entity.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The CropRepository interface provides methods for accessing farms from the database.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-11
 */

public interface CropRepository extends JpaRepository<Crop, Long> {
  List<Crop> findByHarvestDateBetween(LocalDate start, LocalDate end);
}
