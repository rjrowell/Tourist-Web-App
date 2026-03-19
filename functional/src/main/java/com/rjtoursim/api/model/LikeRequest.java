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
 * LikeRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-19T14:22:06.795299Z[Europe/London]", comments = "Generator version: 7.13.0")
public class LikeRequest {

  private String username;

  private Integer postId;

  private @Nullable Boolean status;

  public LikeRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LikeRequest(String username, Integer postId) {
    this.username = username;
    this.postId = postId;
  }

  public LikeRequest username(String username) {
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

  public LikeRequest postId(Integer postId) {
    this.postId = postId;
    return this;
  }

  /**
   * Get postId
   * @return postId
   */
  @NotNull 
  @Schema(name = "postId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("postId")
  public Integer getPostId() {
    return postId;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  public LikeRequest status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LikeRequest likeRequest = (LikeRequest) o;
    return Objects.equals(this.username, likeRequest.username) &&
        Objects.equals(this.postId, likeRequest.postId) &&
        Objects.equals(this.status, likeRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, postId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LikeRequest {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    postId: ").append(toIndentedString(postId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

