package pl.com.redpike.cookbook.service.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.com.redpike.cookbook.data.category.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CategoryRestControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldGetRootCategories() {
        final String url = "/api/category";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldGetAllCategories() {
        final String url = "/api/category/all";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldGetCategoryById() {
        final String url = "/api/category/1";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, Category.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldntFindCategoryById() {
        final String url = "/api/category/9999";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, Category.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void shouldGetCategoryByParentId() {
        final String url = "/api/category/children/1";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldGetChildrenByParentId() {
        final String url = "/api/category/children/2";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, List.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void shouldntGetCategoriesByBrokenParentId() {
        final String url = "/api/category/children/9999";
        ResponseEntity response = this.testRestTemplate.getForEntity(url, List.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}