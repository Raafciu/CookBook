import { TranslateService } from './service/translate/translate.service';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule, APP_INITIALIZER} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './configuration/app-routing.module';
import {MaterialModule} from './module/material/material.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';

import 'hammerjs';
import {WelcomePageComponent} from './views/welcome-page/welcome-page.component';
import {AppComponent} from './app.component';
import {CategoryPageComponent} from './views/category-page/category-page.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MenuItemComponent} from './component/menu-item/menu-item.component';
import {CategoryItemComponent} from './component/category-item/category-item.component';
import {CategoryDialogComponent} from './component/category-dialog/add-edit/category-dialog.component';
import {CategoryRemoveDialogComponent} from './component/category-dialog/remove/category-remove-dialog.component';
import {ReactiveFormsModule} from '@angular/forms';

export function setupTranslateFactory(_translateService: TranslateService): Function {
  return () => _translateService.use('pl');
}

@NgModule({
  declarations: [
    AppComponent,

    // COMPONENTS
    CategoryItemComponent,
    CategoryDialogComponent,
    CategoryRemoveDialogComponent,
    MenuItemComponent,

    // VIEWS
    WelcomePageComponent,
    CategoryPageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    FlexLayoutModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    CategoryDialogComponent,
    CategoryRemoveDialogComponent
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    TranslateService,
    {
      provide: APP_INITIALIZER,
      useFactory: setupTranslateFactory,
      deps: [TranslateService],
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
