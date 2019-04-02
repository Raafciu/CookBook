import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../service/category/category.service';
import {Category} from '../../model/category';
import {map} from 'rxjs/operators';
import {ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {NotificationService} from '../../service/notification/notification.service';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.scss'],
  providers: [CategoryService, NotificationService]
})
export class CategoryPageComponent implements OnInit {

  categories: Category[] = [];

  private currentId = null;

  constructor(private categoryService: CategoryService,
              private notificationService: NotificationService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.currentId = this.route.snapshot.paramMap.get('parentId');
    if (this.currentId) {
      this.refreshContent(this.currentId);
    } else {
      this.categoryService.getCategories()
        .pipe(map(mapCategories))
        .subscribe(data => {
          this.categories = data;
        }, () => {
          this.notificationService.error('Nie mogę pobrać kategorii');
        });
    }
  }

  refreshContent(categoryId: number): void {
    let observable: Observable<any>;
    if (categoryId) {
      observable = this.categoryService.getCategoriesByParentId(categoryId);
    } else {
      observable = this.categoryService.getCategories();
    }

    observable.pipe(map(mapCategories))
      .subscribe(data => {
        this.categories = data;
      }, () => {
        this.notificationService.default('Kategoria ' + categoryId + ' nie posiada podkategorii');
      });
  }
}

function mapCategories(categories) {
  return categories.map(categoryJson =>
    new Category(categoryJson.id, categoryJson.name, 'data:image/jpg;base64,' + categoryJson.categoryPhoto,
      categoryJson.parent, categoryJson.children)
  );
}
