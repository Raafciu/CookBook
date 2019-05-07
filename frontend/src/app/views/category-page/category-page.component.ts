import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../service/category/category.service';
import {Category} from '../../model/category';
import {map} from 'rxjs/operators';
import {ActivatedRoute, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {NotificationService} from '../../service/notification/notification.service';
import {CATEGORY_ID_PARAMETER, CATEGORY_PATH, HOME_PATH} from '../../configuration/paths';

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
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params.forEach(params => {
      this.currentId = params[CATEGORY_ID_PARAMETER];
      let observable: Observable<any>;
      if (this.currentId) {
        observable = this.categoryService.getCategoriesByParentId(this.currentId);
      } else {
        observable = this.categoryService.getCategories();
      }

      observable
        .pipe(map(mapCategories))
        .subscribe(data => {
          this.categories = data;
        }, () => {
          this.categories = [];
          this.notificationService.default('Kategoria ' + this.currentId + ' nie posiada podkategorii');
        });
    });
  }

  refreshContent(categoryId: number): void {
    this.router.navigateByUrl(HOME_PATH + '/' + CATEGORY_PATH + '/' + categoryId);
  }
}

function mapCategories(categories) {
  return categories.map(categoryJson =>
    new Category(categoryJson.id, categoryJson.name, 'data:image/jpg;base64,' + categoryJson.categoryPhoto,
      categoryJson.parent, categoryJson.children)
  );
}
