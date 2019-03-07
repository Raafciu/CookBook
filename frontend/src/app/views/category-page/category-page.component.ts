import {Component, OnInit} from "@angular/core";
import {CategoryService} from "../../service/category/category.service";

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  providers: [CategoryService]
})
export class CategoryPageComponent implements OnInit {

  categories: [] = [];

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe(data => {
      this.categories = data;
    }, error => {
      console.log('Nie pykło');
    })
  }
}
