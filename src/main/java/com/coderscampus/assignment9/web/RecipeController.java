package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.services.FileReaderService;
import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @GetMapping("/gluten-free")
    public List<Recipe> glutenFreeRecipes() {
        return recipeService.getGlutenFreeRecipes();
    }

    @GetMapping("/vegan")
    public List<Recipe> veganRecipes() {
        return recipeService.getVeganRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenFreeRecipes() {
        return recipeService.getVeganAndGlutenFreeRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> vegetarianRecipes() {
        return recipeService.getVegetarianRecipes();
    }

    @GetMapping("/all-recipes")
    public List<Recipe> allRecipes() {
        return recipeService.getRecipe();
    }
}
