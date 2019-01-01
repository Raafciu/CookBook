import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './configuration/app-routing.module';
import { MaterialModule } from "./module/material/material.module";
import { BookComponent } from "./component/book/book.component";
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BookService} from "./service/book.service";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";

import 'hammerjs';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule
  ],
  providers: [
    BookService,
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent, BookComponent]
})
export class AppModule { }
