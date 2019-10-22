import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Category} from '../../../model/category/category';
import {CategoryService} from '../../../service/category/category.service';

const DIALOG_HEADER = 'Usuwanie kategorii';

@Component({
  selector: 'app-category-remove-dialog',
  templateUrl: './category-remove-dialog.component.html',
  styleUrls: ['./category-remove-dialog.component.scss'],
  providers: [CategoryService]
})
export class CategoryRemoveDialogComponent implements OnInit {

  category: Category;
  dialogHeader = DIALOG_HEADER;

  constructor(private dialogRef: MatDialogRef<CategoryRemoveDialogComponent>,
              @Inject(MAT_DIALOG_DATA) data,
              private categoryService: CategoryService) {
    this.category = data;
  }

  ngOnInit(): void {
    this.dialogHeader += ' ' + this.category.name;
  }

  closeDialog() {
    this.dialogRef.close();
  }

  removeCategory(category: Category) {

  }
}
