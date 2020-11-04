package com.nibuton.food.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_x_ingredient")
public class RecipeXIngredient {
	
	@EmbeddedId
	private IngredientRecipeId ingredientRecipeId = new IngredientRecipeId();
    
    @Column(name = "amount")
    double amount;
    
    @ManyToOne
    @MapsId("ingredientId")
    private Ingredient ingredient;
    
    @ManyToOne
    @MapsId("recipeId")
    private Recipe recipe;
	
	public RecipeXIngredient() {
		// TODO Auto-generated constructor stub
	}

	public RecipeXIngredient(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public IngredientRecipeId getIngredientRecipeId() {
		return ingredientRecipeId;
	}

	public void setIngredientRecipeId(IngredientRecipeId ingredientRecipeId) {
		this.ingredientRecipeId = ingredientRecipeId;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "RecipeXIngredient [ingredientRecipeId=" + ingredientRecipeId + ", amount=" + amount + ", ingredient="
				+ ingredient + ", recipe=" + recipe + "]";
	}
	
}
