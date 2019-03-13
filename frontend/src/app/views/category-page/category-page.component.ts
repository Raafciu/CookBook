import {Component, OnInit} from "@angular/core";
import {CategoryService} from "../../service/category/category.service";
import {Category} from "../../model/category";
import {map} from "rxjs/operators";

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
      .pipe(
        map(categories => categories.map(categoryJson =>
            new Category(categoryJson.id, categoryJson.name, 'data:image/jpg;base64,' + categoryJson.categoryPhoto, categoryJson.parent)
          )
        )
      )
      .subscribe(data => {
        this.categories = data;
      }, error => {
        console.log('Nie pykło');
      });
  }
}
