package com.nibuton.food.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "remaining")
	Double remaining;
	
	@Column(name = "created_at")
	Timestamp createdAt;
	
	@OneToMany(mappedBy = "ingredient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RecipeXIngredient> recipeXIngredients = new HashSet<>();
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String name, Double remaining, Timestamp createdAt) {
		super();
		this.name = name;
		this.remaining = remaining;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRemaining() {
		return remaining;
	}

	public void setRemaining(Double remaining) {
		this.remaining = remaining;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Set<RecipeXIngredient> getRecipeXIngredients() {
		return recipeXIngredients;
	}

	public void setRecipeXIngredients(Set<RecipeXIngredient> recipeXIngredients) {
		this.recipeXIngredients = recipeXIngredients;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", remaining=" + remaining + ", createdAt=" + createdAt
				+ "]";
	}
}
