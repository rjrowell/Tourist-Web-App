package com.rjtoursim.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.rjtoursim.api.model.PostDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FetchPostsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-18T16:09:53.044536Z[Europe/London]", comments = "Generator version: 7.13.0")
public class FetchPostsResponse {

  @Valid
  private List<@Valid PostDTO> posts = new ArrayList<>();

  public FetchPostsResponse posts(List<@Valid PostDTO> posts) {
    this.posts = posts;
    return this;
  }

  public FetchPostsResponse addPostsItem(PostDTO postsItem) {
    if (this.posts == null) {
      this.posts = new ArrayList<>();
    }
    this.posts.add(postsItem);
    return this;
  }

  /**
   * Get posts
   * @return posts
   */
  @Valid 
  @Schema(name = "posts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("posts")
  public List<@Valid PostDTO> getPosts() {
    return posts;
  }

  public void setPosts(List<@Valid PostDTO> posts) {
    this.posts = posts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FetchPostsResponse fetchPostsResponse = (FetchPostsResponse) o;
    return Objects.equals(this.posts, fetchPostsResponse.posts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(posts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FetchPostsResponse {\n");
    sb.append("    posts: ").append(toIndentedString(posts)).append("\n");
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

