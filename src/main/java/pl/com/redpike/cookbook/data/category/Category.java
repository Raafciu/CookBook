package pl.com.redpike.cookbook.data.category;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Lob
    @Column(name = "category_photo")
    private byte[] categoryPhoto;

    @Column(name = "parent_id")
    private Integer parentId;
}
