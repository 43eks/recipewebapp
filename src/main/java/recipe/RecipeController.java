package com.example.recipeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "http://localhost:3000") // フロントエンドからのアクセス許可
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    // すべてのレシピを取得
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // 食材リストに基づいてレシピを検索
    @PostMapping("/search")
    public List<Recipe> searchRecipes(@RequestBody List<String> ingredients) {
        return recipeService.findRecipesByIngredients(ingredients);
    }

    // レシピを追加
    @PostMapping
    public String addRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "レシピが追加されました!";
    }
}