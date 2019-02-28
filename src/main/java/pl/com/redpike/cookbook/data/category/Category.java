package pl.com.redpike.cookbook.data.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"categoryPhoto"})
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Lob
    @Column(name = "category_photo")
    private byte[] categoryPhoto;

    @Column(name = "parent", nullable = true)
    private Integer parentId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "parent", nullable = true, insertable = false, updatable = false)
    private Category parent;
}
