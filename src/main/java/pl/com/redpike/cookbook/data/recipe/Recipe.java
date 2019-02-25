package pl.com.redpike.cookbook.data.recipe;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.com.redpike.cookbook.data.recipe_component.RecipeComponent;
import pl.com.redpike.cookbook.data.recipe_step.RecipeStep;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Lob
    @Column(name = "recipe_photo")
    private byte[] recipePhoto;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<RecipeComponent> components;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<RecipeStep> steps;
}
