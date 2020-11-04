package com.nibuton.food.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nibuton.food.entity.Recipe;
import com.nibuton.food.service.RecipeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeController.class)
class RecipeControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	RecipeService recipeService;
	
	private Recipe recipe = new Recipe();
	
	private String fooJson = "{\"name\":\"Rolls\",\"description\":\"Tasty\"}";
	
	{
		recipe.setId(1);
		recipe.setName("test");
		recipe.setDescription("test");
	}

	@Test
	void testGetRecipeById() throws Exception {
		Mockito.when(recipeService.findById(Mockito.anyInt())).thenReturn(Optional.of(recipe));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8002/recipes/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Heyheyehey");
		String expected = "{id:1,name:test,description:test}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
