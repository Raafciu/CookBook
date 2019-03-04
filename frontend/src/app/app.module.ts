import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from './configuration/app-routing.module';
import {MaterialModule} from "./module/material/material.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";

import 'hammerjs';
import {WelcomePageComponent} from "./views/welcome-page/welcome-page.component";

@NgModule({
  declarations: [
    WelcomePageComponent
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
  bootstrap: [WelcomePageComponent]
})
export class AppModule {
}
