import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WelcomePageComponent} from "../views/welcome-page/welcome-page.component";
import {CATEGORY_PATH, HOME_PATH, TEST_PATH} from "./paths";
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
        path: CATEGORY_PATH,
        component: CategoryPageComponent
      },
      {
        path: TEST_PATH,
        component: TestComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
