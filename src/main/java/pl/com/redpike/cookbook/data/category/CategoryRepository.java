package pl.com.redpike.cookbook.data.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("from Category c where c.parent = null")
    List<Category> findRootCategory();

    @Query("from Category c where c.name = :name")
    Optional<Category> findCategoryByName(String name);

    @Query("from Category c where c.parentId = :parent")
    Optional<List<Category>> findCategoryByParentId(Integer parent);
}
