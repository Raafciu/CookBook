package pl.com.redpike.cookbook.data.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.com.redpike.cookbook.data.category.Category;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query("from Recipe r where r.name = :name")
    Optional<Recipe> findRecipeByName(String name);

    @Query("from Recipe r where r.category = :category")
    Optional<List<Recipe>> findRecipeByCategory(Category category);
}
