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
 * AuthResponse
 */

@JsonTypeName("authResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-19T14:22:06.795299Z[Europe/London]", comments = "Generator version: 7.13.0")
public class AuthResponse {

  private @Nullable Integer resp;

  private @Nullable Boolean authSuccess;

  public AuthResponse resp(Integer resp) {
    this.resp = resp;
    return this;
  }

  /**
   * Get resp
   * @return resp
   */
  
  @Schema(name = "resp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resp")
  public Integer getResp() {
    return resp;
  }

  public void setResp(Integer resp) {
    this.resp = resp;
  }

  public AuthResponse authSuccess(Boolean authSuccess) {
    this.authSuccess = authSuccess;
    return this;
  }

  /**
   * Get authSuccess
   * @return authSuccess
   */
  
  @Schema(name = "authSuccess", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authSuccess")
  public Boolean getAuthSuccess() {
    return authSuccess;
  }

  public void setAuthSuccess(Boolean authSuccess) {
    this.authSuccess = authSuccess;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthResponse authResponse = (AuthResponse) o;
    return Objects.equals(this.resp, authResponse.resp) &&
        Objects.equals(this.authSuccess, authResponse.authSuccess);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resp, authSuccess);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponse {\n");
    sb.append("    resp: ").append(toIndentedString(resp)).append("\n");
    sb.append("    authSuccess: ").append(toIndentedString(authSuccess)).append("\n");
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

