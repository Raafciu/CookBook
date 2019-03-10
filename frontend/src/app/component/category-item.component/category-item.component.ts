import {Component, Input} from "@angular/core";
import {Category} from "../../model/category";

@Component({
  selector: 'app-category-item',
  templateUrl: '/category-item.component.html',
  styleUrls: ['./category-item.component.scss']
})
export class CategoryItemComponent {

  @Input() category: Category;
}
