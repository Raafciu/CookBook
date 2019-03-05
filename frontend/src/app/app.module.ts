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

@NgModule({
  declarations: [
    AppComponent,

    // VIEWS
    WelcomePageComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
