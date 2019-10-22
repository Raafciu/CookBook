import {Component, Input} from '@angular/core';
import {Category} from '../../model/category/category';
import {MatDialog} from '@angular/material';
import {CategoryDialogComponent} from '../category-dialog/add-edit/category-dialog.component';
import {CategoryRemoveDialogComponent} from '../category-dialog/remove/category-remove-dialog.component';

@Component({
  selector: 'app-category-item',
  templateUrl: './category-item.component.html',
  styleUrls: ['./category-item.component.scss']
})
export class CategoryItemComponent {

  @Input() category: Category;

  constructor(private matDialog: MatDialog) {
  }

  editCategory(category: Category): void {
    this.matDialog.open(CategoryDialogComponent, {
      data: category
    });
  }

  removeCategory(category: Category) {
    this.matDialog.open(CategoryRemoveDialogComponent, {
      data: category
    });
  }
}
