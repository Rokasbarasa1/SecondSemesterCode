package Clients.Chef.mediator;

import java.io.FileNotFoundException;

public class RecipeProxy implements RecipeProvider {
    private RecipeReader file;
    private Recipe cache;

    public RecipeProxy() {
        file = new RecipeReader("C:\\recipes.txt");
    }

    @Override
    public Recipe getRecipeById(String id)  throws Exception {
        try {
            if (cache.getId().equals(id))
                return cache;
            else {
                cache = file.getRecipeById(id);
                return cache;
            }
        } catch (Exception e){
            System.out.println("No cache");
            try {
                cache = file.getRecipeById(id);
                return cache;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("somehow skipped everything");
        return null;
    }

    @Override
    public Recipe getRecipeByName(String name) throws Exception{
        try {
            if (cache.getName().equals(name))
                return cache;
        } catch (NullPointerException e){
            System.out.println("No cache");
            try {
                cache = file.getRecipeByName(name);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            return cache;
        }
        return null;
    }

    @Override
    public void updateRecipe(Recipe recipe) throws Exception {
        file.updateRecipe(recipe);
    }
}
