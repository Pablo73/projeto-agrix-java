package com.betrybe.agrix.models.repository;

import com.betrybe.agrix.models.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The FarmRepository interface provides methods for accessing farms from the database.
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-10
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}