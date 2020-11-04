package com.nibuton.food.configuration;

import java.sql.Timestamp;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.nibuton.food.dao.IngredientRepository;
import com.nibuton.food.dao.RecipeRepository;
import com.nibuton.food.dao.RecipeXIngredientRepository;
import com.nibuton.food.entity.Ingredient;
import com.nibuton.food.entity.Recipe;
import com.nibuton.food.entity.RecipeXIngredient;

@Configuration
public class LoadData {
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer()
	{
	    return RepositoryRestConfigurer.withConfig(config -> {
	        config.exposeIdsFor(Recipe.class);
	        config.exposeIdsFor(Ingredient.class);
	    });
	}
	
	@Bean
	CommandLineRunner initDatabase(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeXIngredientRepository recipeXIngredientRepository) {
		
		/*Ingredient ingredient1 = new Ingredient("Rice",100.1, null);
		Ingredient ingredient2 = new Ingredient("Chicken",110.1, null);
		Recipe recipe = new Recipe("Rice","ofngpnfg",null);
		RecipeXIngredient recipeXIngredient1 = new RecipeXIngredient(100.200);
		recipeXIngredient1.setIngredient(ingredient1);
		recipeXIngredient1.setRecipe(recipe);
		RecipeXIngredient recipeXIngredient2 = new RecipeXIngredient(200.4);
		recipeXIngredient2.setIngredient(ingredient2);
		recipeXIngredient2.setRecipe(recipe);*/
	    return args -> {
	      /*ingredientRepository.deleteById(1);
	      ingredientRepository.save(ingredient1);
	      ingredientRepository.save(ingredient2);
	      recipeRepository.save(recipe);
	      recipeXIngredientRepository.save(recipeXIngredient1);
	      recipeXIngredientRepository.save(recipeXIngredient2);
	      some additional comments*/
	      
	      
	    };
	  }

}
