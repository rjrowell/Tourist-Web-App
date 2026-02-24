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
 * GetLikeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-24T18:13:32.608963Z[Europe/London]", comments = "Generator version: 7.13.0")
public class GetLikeResponse {

  private @Nullable Boolean likeStatus;

  public GetLikeResponse likeStatus(Boolean likeStatus) {
    this.likeStatus = likeStatus;
    return this;
  }

  /**
   * Get likeStatus
   * @return likeStatus
   */
  
  @Schema(name = "likeStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("likeStatus")
  public Boolean getLikeStatus() {
    return likeStatus;
  }

  public void setLikeStatus(Boolean likeStatus) {
    this.likeStatus = likeStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLikeResponse getLikeResponse = (GetLikeResponse) o;
    return Objects.equals(this.likeStatus, getLikeResponse.likeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(likeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLikeResponse {\n");
    sb.append("    likeStatus: ").append(toIndentedString(likeStatus)).append("\n");
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

