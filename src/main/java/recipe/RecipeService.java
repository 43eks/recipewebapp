package com.example.recipeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findRecipesByIngredients(List<String> ingredients) {
        return recipeRepository.findAll().stream()
            .filter(recipe -> ingredients.stream().allMatch(recipe.getIngredients()::contains))
            .toList();
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
