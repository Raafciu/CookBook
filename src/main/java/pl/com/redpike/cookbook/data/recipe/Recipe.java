package pl.com.redpike.cookbook.data.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.com.redpike.cookbook.data.recipe_ingredient.RecipeIngredient;
import pl.com.redpike.cookbook.data.recipe_step.RecipeStep;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, unique = true)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Lob
    @Column(name = "recipe_photo")
    private byte[] recipePhoto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<RecipeIngredient> ingredients;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<RecipeStep> steps;
}
