package com.nibuton.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.food.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
