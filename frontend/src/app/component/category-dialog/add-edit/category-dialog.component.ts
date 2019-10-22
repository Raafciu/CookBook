import {Component, Inject, OnInit} from '@angular/core';
import {Category} from '../../../model/category/category';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../../service/category/category.service';

const ADD_DIALOG_HEADER = 'Dodawanie nowej kategorii';
const EDIT_DIALOG_HEADER = 'Edycja kategorii ';

@Component({
  selector: 'app-category-dialog',
  templateUrl: './category-dialog.component.html',
  styleUrls: ['./category-dialog.component.scss'],
  providers: [CategoryService]
})
export class CategoryDialogComponent implements OnInit {

  category: Category;
  dialogHeader = '';

  form: FormGroup;
  nameFC: FormControl;

  constructor(private dialogRef: MatDialogRef<CategoryDialogComponent>,
              @Inject(MAT_DIALOG_DATA) data,
              private formBuilder: FormBuilder,
              private categoryService: CategoryService) {
    this.category = data;
  }

  ngOnInit(): void {
    this.nameFC = new FormControl('');

    this.form = this.formBuilder.group({
      name: this.nameFC
    });

    this.setDialogHeaderAndData();
  }

  private setDialogHeaderAndData() {
    console.log(this.category);
    if (this.category) {
      this.dialogHeader = EDIT_DIALOG_HEADER + ' ' + this.category.name;
      this.form.patchValue(this.category);
    } else {
      this.dialogHeader = ADD_DIALOG_HEADER;
    }
  }

  editCategory(category: Category) {

  }

  closeDialog() {
    this.dialogRef.close();
  }
}
