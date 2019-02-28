package pl.com.redpike.cookbook.data.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static pl.com.redpike.cookbook.data.DataProperties.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"categoryPhoto"})
@Entity
@Table(name = CATEGORY_TABLE)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CATEGORY_ID_COLUMN, precision = 9, unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = CATEGORY_NAME_COLUMN, length = 80, nullable = false)
    private String name;

    @Lob
    @Column(name = CATEGORY_CATEGORY_PHOTO_COLUMN)
    private byte[] categoryPhoto;

    @Column(name = CATEGORY_PARENT_COLUMN, nullable = true)
    private Integer parentId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = CATEGORY_PARENT_COLUMN, nullable = true, insertable = false, updatable = false)
    private Category parent;
}
