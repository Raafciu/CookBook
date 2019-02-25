package pl.com.redpike.cookbook.data.recipe_step;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe_step")
public class RecipeStep {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "body", length = 1000, nullable = false)
    private String body;
}
