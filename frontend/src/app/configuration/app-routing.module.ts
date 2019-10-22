import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WelcomePageComponent} from '../views/welcome-page/welcome-page.component';
import {CATEGORY_ID_PARAMETER_PATH, CATEGORY_PATH, HOME_PATH, TEST_PATH} from './paths';
import {CategoryPageComponent} from '../views/category-page/category-page.component';

const ROUTES: Routes = [
  {
    path: '',
    component: WelcomePageComponent,
  },
  // {
  //   path: HOME_PATH,
  //   component: HomePageComponent,
  //   children: [
  //     {
  //       path: CATEGORY_PATH,
  //       component: CategoryPageComponent
  //     },
  //     {
  //       path: CATEGORY_PATH + '/' + CATEGORY_ID_PARAMETER_PATH,
  //       component: CategoryPageComponent
  //     },
  //     {
  //       path: TEST_PATH,
  //       component: TestComponent
  //     }
  //   ]
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
