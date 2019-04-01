import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../service/category/category.service';
import {Category} from '../../model/category';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.scss'],
  providers: [CategoryService]
})
export class CategoryPageComponent implements OnInit {

  categories: Category[] = [];

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getCategories()
      .pipe(map(mapCategories))
      .subscribe(data => {
        this.categories = data;
      }, error => {
        console.log('Nie pykło');
      });
  }

  refreshContent(categoryId: number): void {
    console.log(categoryId);
    this.categoryService.getCategoriesByParentId(categoryId)
      .pipe(
        map(value => {
          console.log(value);
          return new Category(value.id, value.name, 'data:image/jpg;base64,' + value.categoryPhoto, value.parent, value.children);
        })
      )
      .subscribe(response => {
        const category = response;
        if (category.children.length !== 0) {
          // TODO Routing
          console.log(category.children);
          this.categories = category.children;
        }
      });
  }
}

function mapCategories(categories) {
  return categories.map(categoryJson =>
    new Category(categoryJson.id, categoryJson.name, 'data:image/jpg;base64,' + categoryJson.categoryPhoto,
      categoryJson.parent, categoryJson.children)
  );
}
