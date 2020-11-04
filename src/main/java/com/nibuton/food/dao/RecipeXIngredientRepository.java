package com.nibuton.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.food.entity.IngredientRecipeId;
import com.nibuton.food.entity.RecipeXIngredient;

public interface RecipeXIngredientRepository extends JpaRepository<RecipeXIngredient, IngredientRecipeId> {
}
