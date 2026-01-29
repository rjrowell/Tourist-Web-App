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
 * AuthUserRequest
 */

@JsonTypeName("authUserRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-29T18:00:27.044696Z[Europe/London]", comments = "Generator version: 7.13.0")
public class AuthUserRequest {

  private char[] hashedPassword = null;

  private @Nullable String username;

  public AuthUserRequest hashedPassword(char[] hashedPassword) {
    this.hashedPassword = hashedPassword;
    return this;
  }

  /**
   * Get hashedPassword
   * @return hashedPassword
   */
  
  @Schema(name = "hashedPassword", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hashedPassword")
  public char[] getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(char[] hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public AuthUserRequest username(String username) {
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
    AuthUserRequest authUserRequest = (AuthUserRequest) o;
    return Objects.equals(this.hashedPassword, authUserRequest.hashedPassword) &&
        Objects.equals(this.username, authUserRequest.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashedPassword, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthUserRequest {\n");
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

