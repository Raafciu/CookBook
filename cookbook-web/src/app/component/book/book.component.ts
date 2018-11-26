import { Component, OnInit } from "@angular/core";
import { BookService } from "../../service/book.service";

import {Book} from "../../model/book/book.model";
import {MatTableDataSource} from "@angular/material";

@Component({
  selector: 'book-list',
  templateUrl: './book.component.html'
})
export class BookComponent implements OnInit {
  books: Array<Book>;
  displayedColumns: string[] = ['id', 'author', 'title', 'pages'];
  dataSource;

  constructor(private bookService: BookService) {

  }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(data => {
      this.books = data;
      this.dataSource = new MatTableDataSource(this.books);
    })
  }

  applyFilter(filteredValue: string) {
    this.dataSource.filter = filteredValue.trim().toLowerCase();
  }
}
