package com.rjtoursim.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateUserRequest
 */

@JsonTypeName("createUserRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-07T22:21:15.413124460Z[Europe/London]", comments = "Generator version: 7.13.0")
public class CreateUserRequest {

  private @Nullable String hashedPassword;

  private @Nullable String username;

  public CreateUserRequest hashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
    return this;
  }

  /**
   * Get hashedPassword
   * @return hashedPassword
   */
  
  @Schema(name = "hashedPassword", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hashedPassword")
  public String getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public CreateUserRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  
  @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserRequest createUserRequest = (CreateUserRequest) o;
    return Objects.equals(this.hashedPassword, createUserRequest.hashedPassword) &&
        Objects.equals(this.username, createUserRequest.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashedPassword, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserRequest {\n");
    sb.append("    hashedPassword: ").append(toIndentedString(hashedPassword)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

