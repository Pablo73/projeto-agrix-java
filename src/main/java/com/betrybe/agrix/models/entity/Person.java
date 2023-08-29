package com.betrybe.agrix.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The Person class represents an individual user entity in the application.
 * This entity is used to store user-related information, such as username, password,
 * and role. It implements both the UserDetails and GrantedAuthority interfaces
 * for compatibility with Spring Security.
 *
 * <p>The class uses the JPA annotations to define its mapping to the database schema.</p>
 * <p>It also implements methods required by the UserDetails and GrantedAuthority interfaces
 * to provide authentication and authorization functionality.</p>
 *
 * @author Pablo
 * @version 1.0
 * @since 2023-08-17
 */
@Entity
public class Person implements UserDetails, GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;

  private String password;

  private String role;

  public Person() {
  }

  /**
   * Constructs a new Person instance with the provided details.
   *
   * @param id The unique identifier of the person.
   * @param username The username of the person.
   * @param password The password of the person.
   * @param role The role associated with the person.
   */
  public Person(Long id, String username, String password, String role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  @JsonIgnore
  public Collection<Person> getAuthorities() {
    return List.of(this);
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @JsonIgnore
  @Override
  public String getAuthority() {
    return this.getRole();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
