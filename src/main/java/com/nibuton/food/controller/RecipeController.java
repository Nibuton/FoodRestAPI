package com.nibuton.food.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nibuton.food.entity.Recipe;
import com.nibuton.food.error.EntityNotFoundException;
import com.nibuton.food.service.RecipeService;
@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;

	public RecipeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(value = "/{id}")
	public Recipe getRecipeById(@PathVariable("id") int id) {
		Optional<Recipe> recipe = recipeService.findById(id);
		if (!recipe.isPresent()) {
			throw new EntityNotFoundException("Recipe with id: " + id + " was not found");
		}
		else {
			return recipe.get();
		}
	}
	
	@GetMapping("/ingredient")
	public void saveNewIngredientForRecipe(@RequestParam("recipeId") int recipeId, @RequestParam("ingredientId") int ingredientId, @RequestParam("amount") double amount) {
		recipeService.saveNewIngredientForRecipe(recipeId, ingredientId, amount);
		return;
	}
}
