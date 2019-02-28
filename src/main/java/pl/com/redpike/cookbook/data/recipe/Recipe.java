package pl.com.redpike.cookbook.data.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.com.redpike.cookbook.data.category.Category;
import pl.com.redpike.cookbook.data.recipe_ingredient.RecipeIngredient;
import pl.com.redpike.cookbook.data.recipe_step.RecipeStep;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static pl.com.redpike.cookbook.data.DataProperties.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipePhoto"})
@Entity
@Table(name = RECIPE_TABLE)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = RECIPE_ID_COLUMN, precision = 9, unique = true)
    private Integer id;

    @NotNull
    @Column(name = RECIPE_NAME_COLUMN, length = 150, nullable = false)
    private String name;

    @Lob
    @Column(name = RECIPE_RECIPE_PHOTO_COLUMN)
    private byte[] recipePhoto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = RECIPE_RECIPE_ID_COLUMN, referencedColumnName = RECIPE_ID_COLUMN)
    private List<RecipeIngredient> ingredients;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = RECIPE_RECIPE_ID_COLUMN, referencedColumnName = RECIPE_ID_COLUMN)
    private List<RecipeStep> steps;

    @OneToOne
    @JoinColumn(name = RECIPE_CATEGORY_COLUMN, referencedColumnName = CATEGORY_ID_COLUMN)
    private Category category;
}
