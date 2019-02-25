package pl.com.redpike.cookbook.data.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query("from Recipe r where r.name = :name")
    Optional<Recipe> findRecipeByName(String name);
}
