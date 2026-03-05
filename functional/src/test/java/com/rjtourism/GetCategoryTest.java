package com.rjtourism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.api.model.CategoryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * A test for the get category endpoint.
 */
@SpringBootTest(classes = com.rjtoursim.Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class GetCategoryTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void getCategoryOneTest() throws Exception {
    CategoryResponse response = objectMapper.readValue(
        mockMvc.perform(get("/v1/content/get-category/" + 1))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString(), CategoryResponse.class
    );

    assertEquals(response.getCategoryName(), "Heritage Site", 
        "Expected 'Heritage Site' but got " + response.getCategoryName());
  }

  @Test
  public void getCategoryTwoTest() throws Exception {
    CategoryResponse response = objectMapper.readValue(
        mockMvc.perform(get("/v1/content/get-category/" + 2))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString(), CategoryResponse.class
    );

    assertEquals(response.getCategoryName(), "Shopping",
          "Expected 'Shopping' but got " + response.getCategoryName());
  }
}
