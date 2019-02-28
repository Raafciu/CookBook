package pl.com.redpike.cookbook.data.recipe_ingredient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static pl.com.redpike.cookbook.data.DataProperties.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = RECIPE_INGREDIENT_TABLE)
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = RECIPE_INGREDIENT_ID_COLUMN, precision = 9, unique = true)
    private Integer id;

    @NotNull
    @Column(name = RECIPE_INGREDIENT_BODY_COLUMN, length = 100, nullable = false)
    private String body;
}
