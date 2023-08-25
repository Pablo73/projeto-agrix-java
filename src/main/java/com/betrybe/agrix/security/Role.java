package com.betrybe.agrix.security;

/**
 * Enumeration representing different roles in a user management system.
 * These roles define the access and permissions that users possess within the system.
 * Roles are commonly used for authentication and authorization purposes.
 *
 * <p>Each role is associated with a name that is often used for access control checks.</p>
 *
 * @since 2023-08-17
 */
public enum Role {
  /**
   * The ADMIN role represents the administrator role.
   * Administrators typically have full access and control over the system.
   */
  ADMIN("ROLE_ADMIN"),

  /**
   * The MANAGER role represents the manager role.
   * Managers may have elevated privileges and control over certain aspects of the system.
   */
  MANAGER("ROLE_MANAGER"),

  /**
   * The USER role represents the standard user role.
   * Regular users have limited access and are restricted from certain administrative tasks.
   */
  USER("ROLE_USER");

  private final String name;

  /**
   * Constructs a new Role enum constant with the given name.
   *
   * @param name The name associated with the role.
   */
  Role(String name) {
    this.name = name;
  }

  /**
   * Get the name associated with the role.
   *
   * @return The name of the role.
   */
  public String getName() {
    return name;
  }
}
