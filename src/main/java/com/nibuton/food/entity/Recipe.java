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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "recipeXIngredients"})
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "created_at")
	Timestamp createdAt;
	
	@OneToMany(mappedBy = "recipe",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RecipeXIngredient> recipeXIngredients = new HashSet<>();
	
	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public Recipe(String name, String description, Timestamp createdAt) {
		super();
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
				+ ", recipeXIngredients=" + recipeXIngredients + "]";
	}
	
}
