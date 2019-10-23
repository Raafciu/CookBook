import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class FrontCarouselService {

  constructor(private http: HttpClient) {
  }

  getSlides(): Observable<any> {
    return this.http.get('assets/images/front-carousel/slides.json');
  }
}
