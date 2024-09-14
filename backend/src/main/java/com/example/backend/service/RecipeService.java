package com.example.backend.service;

import com.example.backend.model.Recipe;
import com.example.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public ResponseEntity<Recipe> addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipe);
    }

    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(recipes);
    }

    public ResponseEntity<Recipe> getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(recipe);
    }

    public ResponseEntity<Void> deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
