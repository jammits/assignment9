package com.coderscampus.assignment9.services;

import com.coderscampus.assignment9.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    FileReaderService fileReaderService;

    public List<Recipe> getRecipe() {
        try {
            return fileReaderService.readRecipes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Recipe> getGlutenFreeRecipes() {
       return getRecipe().stream()
               .filter(Recipe::getGlutenFree)
               .collect(Collectors.toList());
    }

    public List<Recipe> getVeganRecipes() {
        return getRecipe().stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return getRecipe().stream()
                .filter(Recipe::getGlutenFree)
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarianRecipes() {
        return getRecipe().stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());

    }


}
