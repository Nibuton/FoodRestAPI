package com.nibuton.food.service;

import java.util.Optional;

import com.nibuton.food.entity.Recipe;

public interface RecipeService {
	
	void saveNewIngredientForRecipe(int recipeId, int ingredientId, double amount);

	Optional<Recipe> findById(int id);
}
