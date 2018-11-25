import { Component, OnInit } from "@angular/core";
import { BookService } from "../../service/book.service";

@Component({
  selector: 'book-list',
  templateUrl: './book.component.html'
})
export class BookComponent implements OnInit {
  books: Array<any>;

  constructor(private bookService: BookService) {

  }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(data => {
      this.books = data;
    })
  }
}
