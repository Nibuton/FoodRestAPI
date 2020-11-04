package com.nibuton.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.food.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
