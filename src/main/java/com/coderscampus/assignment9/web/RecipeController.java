package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.FileReaderService;
import com.coderscampus.assignment9.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecipeController {

    @Autowired
    FileReaderService fileReaderService;


    @GetMapping("/gluten-free")
    public List<Recipe> glutenFreeRecipes() {
        return fileReaderService.getRecipes().stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
    }

    @GetMapping("/vegan")
    public List<Recipe> veganRecipes() {
        return fileReaderService.getRecipes().stream().filter(Recipe::getVegan).collect(Collectors.toList());
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenFreeRecipes() {
        return fileReaderService.getRecipes().stream().filter(Recipe::getGlutenFree).filter(Recipe::getVegan).collect(Collectors.toList());
    }

    @GetMapping("/vegetarian")
    public List<Recipe> vegetarianRecipes() {
        return fileReaderService.getRecipes().stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
    }

    @GetMapping("/all-recipes")
    public List<Recipe> allRecipes() {
        return fileReaderService.getRecipes();
    }
}
