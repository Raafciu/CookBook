import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<any> {
    // return this.http.get('./assets/mock-categories.json');
    return this.http.get('http://localhost:8080/api/category');
  }

  getCategoriesByParentId(parentId: number): Observable<any> {
    return this.http.get('http://localhost:8080/api/category/' + parentId);
  }
}
