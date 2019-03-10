import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from './configuration/app-routing.module';
import {MaterialModule} from "./module/material/material.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";

import 'hammerjs';
import {WelcomePageComponent} from "./views/welcome-page/welcome-page.component";
import {HomePageComponent} from "./views/home-page/home-page.component";
import {AppComponent} from "./app.component";
import {TestComponent} from "./component/test.component";
import {CategoryPageComponent} from "./views/category-page/category-page.component";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MenuItemComponent} from "./component/menu-item.component/menu-item.component";
import {CategoryItemComponent} from "./component/category-item.component/category-item.component";

@NgModule({
  declarations: [
    AppComponent,

    // COMPONENTS
    CategoryItemComponent,
    MenuItemComponent,

    // VIEWS
    WelcomePageComponent,
    HomePageComponent,
    TestComponent,
    CategoryPageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    FlexLayoutModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
