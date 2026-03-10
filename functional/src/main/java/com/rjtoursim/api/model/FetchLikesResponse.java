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
 * FetchLikesResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-07T15:23:47.880413Z[Europe/London]", comments = "Generator version: 7.13.0")
public class FetchLikesResponse {

  private @Nullable Integer likeCount;

  public FetchLikesResponse likeCount(Integer likeCount) {
    this.likeCount = likeCount;
    return this;
  }

  /**
   * Get likeCount
   * @return likeCount
   */
  
  @Schema(name = "likeCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("likeCount")
  public Integer getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(Integer likeCount) {
    this.likeCount = likeCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FetchLikesResponse fetchLikesResponse = (FetchLikesResponse) o;
    return Objects.equals(this.likeCount, fetchLikesResponse.likeCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(likeCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FetchLikesResponse {\n");
    sb.append("    likeCount: ").append(toIndentedString(likeCount)).append("\n");
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

