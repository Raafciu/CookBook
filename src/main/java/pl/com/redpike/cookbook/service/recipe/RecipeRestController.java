package pl.com.redpike.cookbook.service.recipe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.redpike.cookbook.data.recipe.Recipe;
import pl.com.redpike.cookbook.data.recipe.RecipeRepository;
import pl.com.redpike.cookbook.util.RestUtil;

import java.net.URI;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("${route.api}" + "/" + "${route.recipe.path}")
@CrossOrigin(origins = {RestUtil.ANGULAR_HOST, RestUtil.TOMCAT_HOST})
public class RecipeRestController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public ResponseEntity getAllRecipes() {
        log.info("Getting list of all recipes");

        return ResponseEntity.ok(recipeRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getRecipeById(@PathVariable Integer id) {
        return recipeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRecipe(@RequestBody Recipe recipe) {
        if (recipeRepository.findRecipeByName(recipe.getName()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        else {
            Recipe savedRecipe = recipeRepository.save(recipe);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedRecipe.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Optional<Recipe> optional = recipeRepository.findById(id);

        if (optional.isPresent()) {
            recipe.setId(id);
            recipeRepository.save(recipe);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteRecipe(@PathVariable Integer id) {
        recipeRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
