package com.nibuton.food.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibuton.food.dao.IngredientRepository;
import com.nibuton.food.dao.RecipeRepository;
import com.nibuton.food.dao.RecipeXIngredientRepository;
import com.nibuton.food.entity.IngredientRecipeId;
import com.nibuton.food.entity.Recipe;
import com.nibuton.food.entity.RecipeXIngredient;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository recipeRepository;

	private IngredientRepository ingredientRepository;
	
	private RecipeXIngredientRepository recipeXIngredientRepository;

	@Autowired
	public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, RecipeXIngredientRepository recipeXIngredientRepository) {
		this.ingredientRepository = ingredientRepository;
		this.recipeRepository = recipeRepository;
		this.recipeXIngredientRepository = recipeXIngredientRepository;
	}

	@Override
	public void saveNewIngredientForRecipe(int recipeId, int ingredientId, double amount) {
		Optional<RecipeXIngredient> found = recipeXIngredientRepository.findById(new IngredientRecipeId(recipeId, ingredientId));
		if (!found.isPresent()){
			RecipeXIngredient recipeXIngredient = new RecipeXIngredient(amount);
			recipeXIngredient.setIngredient(ingredientRepository.findById(ingredientId).get());
			recipeXIngredient.setRecipe(recipeRepository.findById(recipeId).get());
			recipeXIngredientRepository.save(recipeXIngredient);
		}
		else {
			RecipeXIngredient recipeXIngredient = found.get();
			recipeXIngredient.setAmount(amount);
			recipeXIngredientRepository.save(recipeXIngredient);
		}
	}
	
	@Override
	public Optional<Recipe> findById(int id) {
		return recipeRepository.findById(id);
	}

}
