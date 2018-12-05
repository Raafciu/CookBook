package pl.com.redpike.cookbookserver.service.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.redpike.cookbookserver.data.book.Book;
import pl.com.redpike.cookbookserver.util.RestUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestUtil.BOOK_API)
@CrossOrigin(origins = RestUtil.ANGULAR_HOST)
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

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
}
