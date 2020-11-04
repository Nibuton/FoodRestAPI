package com.nibuton.food.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.nibuton.food.entity.Ingredient;

@RunWith(SpringRunner.class)
@DataJpaTest
class IngredientRepositoryIntegrationTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	IngredientRepository ingredientRepository;

	@Test
	public void whenFindById_thenReturnIngredient() {
		
		Ingredient ingredient = new Ingredient();
		ingredient.setName("Eggs");
		ingredient.setRemaining(10.2);
		ingredient.setCreatedAt(null);
		
		entityManager.persist(ingredient);
		entityManager.flush();
		
		Ingredient ingredientFound = ingredientRepository.findById(ingredient.getId()).get();
		
		assertEquals(ingredientFound.getName(),ingredient.getName());
		
	}

}
