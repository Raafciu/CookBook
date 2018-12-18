import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

import {Book} from "../model/book/book.model";
import {BOOKS_API} from "../configuration/apiPaths";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BookService {

  constructor(private http: HttpClient) {
  }

  getBooks(): Observable<any> {
    return this.http.get<Book[]>(BOOKS_API);
  }
}
