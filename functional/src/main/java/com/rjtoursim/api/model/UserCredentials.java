package com.rjtoursim.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UserCredentials
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-24T18:13:32.608963Z[Europe/London]", comments = "Generator version: 7.13.0")
public class UserCredentials {

  private String hashedPassword;

  private String username;

  private Boolean isAdmin;

  public UserCredentials() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserCredentials(String hashedPassword, String username, Boolean isAdmin) {
    this.hashedPassword = hashedPassword;
    this.username = username;
    this.isAdmin = isAdmin;
  }

  public UserCredentials hashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
    return this;
  }

  /**
   * Get hashedPassword
   * @return hashedPassword
   */
  @NotNull 
  @Schema(name = "hashedPassword", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hashedPassword")
  public String getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public UserCredentials username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  @NotNull 
  @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserCredentials isAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
    return this;
  }

  /**
   * Get isAdmin
   * @return isAdmin
   */
  @NotNull 
  @Schema(name = "isAdmin", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isAdmin")
  public Boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCredentials userCredentials = (UserCredentials) o;
    return Objects.equals(this.hashedPassword, userCredentials.hashedPassword) &&
        Objects.equals(this.username, userCredentials.username) &&
        Objects.equals(this.isAdmin, userCredentials.isAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashedPassword, username, isAdmin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCredentials {\n");
    sb.append("    hashedPassword: ").append(toIndentedString(hashedPassword)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    isAdmin: ").append(toIndentedString(isAdmin)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

