package pl.com.redpike.cookbook.service.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.redpike.cookbook.data.category.Category;
import pl.com.redpike.cookbook.data.category.CategoryRepository;
import pl.com.redpike.cookbook.util.RestUtil;

import java.net.URI;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("${route.api}" + "/" + "${route.category.path}")
@CrossOrigin(origins = {RestUtil.ANGULAR_HOST, RestUtil.TOMCAT_HOST})
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity getAllCategories() {
        log.info("Getting list of all categories");

        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getCategoryById(@PathVariable Integer id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCategory(@RequestBody Category category) {
        if (categoryRepository.findCategoryByName(category.getName()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        else {
            Category savedCategory = categoryRepository.save(category);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedCategory.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editCategory(@PathVariable Integer id, @RequestBody Category category) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()) {
            category.setId(id);
            categoryRepository.save(category);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        categoryRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
