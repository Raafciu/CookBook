import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CATEGORY_API, CATEGORY_CHILDREN_API} from '../../configuration/apiPaths';

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<any> {
    // return this.http.get('./assets/mock-categories.json');
    return this.http.get(CATEGORY_API);
  }

  getCategoriesByParentId(parentId: number): Observable<any> {
    return this.http.get(CATEGORY_CHILDREN_API + parentId);
  }
}
