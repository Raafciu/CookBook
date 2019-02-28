package pl.com.redpike.cookbook.data.recipe_step;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static pl.com.redpike.cookbook.data.DataProperties.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = RECIPE_STEP_TABLE)
public class RecipeStep {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = RECIPE_STEP_ID_COLUMN, precision = 9, unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = RECIPE_STEP_BODY_COLUMN, length = 1000, nullable = false)
    private String body;
}
