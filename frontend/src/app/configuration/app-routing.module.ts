import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WelcomePageComponent} from "../views/welcome-page/welcome-page.component";
import {HOME_PATH} from "./paths";
import {HomePageComponent} from "../views/home-page/home-page.component";
import {TestComponent} from "../component/test.component";
import {CategoryPageComponent} from "../views/category-page/category-page.component";

const ROUTES: Routes = [
  {
    path: '',
    component: WelcomePageComponent,
  },
  {
    path: HOME_PATH,
    component: HomePageComponent,
    children: [
      {
        path: 'test',
        component: TestComponent
      },
      {
        path: 'category',
        component: CategoryPageComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
