package com.betrybe.agrix.models.repository;

import com.betrybe.agrix.models.entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Person JPA repository.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findByUsername(String username);
}
