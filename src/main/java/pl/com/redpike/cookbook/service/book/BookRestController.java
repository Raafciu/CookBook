package pl.com.redpike.cookbook.service.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.redpike.cookbook.data.book.Book;
import pl.com.redpike.cookbook.util.RestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({RestUtil.BOOK_API, RestUtil.BOOK_DEV_API})
@CrossOrigin(origins = {RestUtil.ANGULAR_HOST, RestUtil.TOMCAT_HOST})
public class BookRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRestController.class);

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        LOGGER.info("Getting list of all books.");
        if (books.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        LOGGER.info("Getting book by id " + id);
        Optional<Book> optional = books.stream()
                .filter(book -> book.getId().compareTo(id) == 0)
                .findAny();
        return optional
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        LOGGER.info("Creating new book " + book.toString());
        books.add(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
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

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        LOGGER.info("Deleting book by id " + id);
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
