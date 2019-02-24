package pl.com.redpike.cookbook.service.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.redpike.cookbook.data.book.Book;
import pl.com.redpike.cookbook.data.book.BookRepository;
import pl.com.redpike.cookbook.util.RestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("${route.api}" + "/" + "${route.books.path}")
@CrossOrigin(origins = {RestUtil.ANGULAR_HOST, RestUtil.TOMCAT_HOST})
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    private static List<Book> books;

    static {
        books = new ArrayList<>();
        books.add(new Book(1, "Rafałek", "PoE", "234"));
        books.add(new Book(2, "Przemus", "Izaro", "234"));
        books.add(new Book(3, "Rafałek", "PoE", "234"));
        books.add(new Book(4, "Rafałek", "PoE", "234"));
        books.add(new Book(5, "Rafałek", "PoE", "234"));
        books.add(new Book(6, "Rafałek", "PoE", "234"));
        books.add(new Book(7, "Rafałek", "PoE", "234"));
        books.add(new Book(8, "Rafałek", "PoE", "234"));
    }

    @GetMapping
    public ResponseEntity getBooks() {
        log.info("Getting list of all books.");

        return ResponseEntity.ok(bookRepository.findAll());
    }


    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        log.info("Getting book by id " + id);
        Optional<Book> optional = books.stream()
                .filter(book -> book.getId().compareTo(id) == 0)
                .findAny();
        return optional
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.info("Creating new book " + book.toString());
        books.add(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Book> editBook(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> optional = books.stream()
                .filter(b -> b.getId().compareTo(id) == 0)
                .findAny();
        if (optional.isPresent()) {
            Book editedBook = optional.get();
            books.remove(editedBook);
            books.add(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity deleteBook(@PathVariable Integer id) {
        log.info("Deleting book by id " + id);
        Optional<Book> optional = books.stream()
                .filter(book -> book.getId().compareTo(id) == 0)
                .findAny();
        if (optional.isPresent()) {
            Book book = optional.get();
            books.remove(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
