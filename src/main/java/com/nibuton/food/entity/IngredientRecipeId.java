package com.nibuton.food.entity;

import java.io.Serializable;
import java.util.Objects;

public class IngredientRecipeId implements Serializable {
	
	private Integer recipeId;
	
	private Integer ingredientId;
	
	private static final long serialVersionUID = 1L;

	public IngredientRecipeId() {
		// TODO Auto-generated constructor stub
	}
	
	public IngredientRecipeId(int recipeId, int ingredientId) {
		super();
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((recipeId == null) ? 0 : recipeId.hashCode());
        result = prime * result
                + ((ingredientId == null) ? 0 : ingredientId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IngredientRecipeId other = (IngredientRecipeId) obj;
        return Objects.equals(getIngredientId(), other.getIngredientId()) && Objects.equals(getRecipeId(), other.getRecipeId());
    }
}
