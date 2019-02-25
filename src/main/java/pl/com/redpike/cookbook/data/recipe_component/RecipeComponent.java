package pl.com.redpike.cookbook.data.recipe_component;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe_component")
public class RecipeComponent {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "body", length = 100, nullable = false)
    private String body;
}
