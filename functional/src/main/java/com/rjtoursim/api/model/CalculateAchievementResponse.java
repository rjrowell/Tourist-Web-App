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
 * CalculateAchievementResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-03T13:16:18.488897Z[Europe/London]", comments = "Generator version: 7.13.0")
public class CalculateAchievementResponse {

  private @Nullable Boolean fiveLikesAchievement;

  public CalculateAchievementResponse fiveLikesAchievement(Boolean fiveLikesAchievement) {
    this.fiveLikesAchievement = fiveLikesAchievement;
    return this;
  }

  /**
   * Get fiveLikesAchievement
   * @return fiveLikesAchievement
   */
  
  @Schema(name = "FiveLikesAchievement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("FiveLikesAchievement")
  public Boolean getFiveLikesAchievement() {
    return fiveLikesAchievement;
  }

  public void setFiveLikesAchievement(Boolean fiveLikesAchievement) {
    this.fiveLikesAchievement = fiveLikesAchievement;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculateAchievementResponse calculateAchievementResponse = (CalculateAchievementResponse) o;
    return Objects.equals(this.fiveLikesAchievement, calculateAchievementResponse.fiveLikesAchievement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fiveLikesAchievement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculateAchievementResponse {\n");
    sb.append("    fiveLikesAchievement: ").append(toIndentedString(fiveLikesAchievement)).append("\n");
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

