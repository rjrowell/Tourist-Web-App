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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-24T18:13:32.608963Z[Europe/London]", comments = "Generator version: 7.13.0")
public class CalculateAchievementResponse {

  private @Nullable Boolean _5likesAchievement;

  public CalculateAchievementResponse _5likesAchievement(Boolean _5likesAchievement) {
    this._5likesAchievement = _5likesAchievement;
    return this;
  }

  /**
   * Get _5likesAchievement
   * @return _5likesAchievement
   */
  
  @Schema(name = "5LikesAchievement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("5LikesAchievement")
  public Boolean get5likesAchievement() {
    return _5likesAchievement;
  }

  public void set5likesAchievement(Boolean _5likesAchievement) {
    this._5likesAchievement = _5likesAchievement;
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
    return Objects.equals(this._5likesAchievement, calculateAchievementResponse._5likesAchievement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_5likesAchievement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculateAchievementResponse {\n");
    sb.append("    _5likesAchievement: ").append(toIndentedString(_5likesAchievement)).append("\n");
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

