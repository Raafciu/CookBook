import {Component} from "@angular/core";
import {CATEGORY_PATH, TEST_PATH} from "../../configuration/paths";

@Component({
  selector: 'app-menu-item',
  templateUrl: './menu-item.component.html',
  styleUrls: ['./menu-item.component.scss']
})
export class MenuItemComponent {

  MENU_ITEMS = [
    {
      group: 'Znajdź przepis',
      items: [
        {
          name: 'Kategorie',
          path: CATEGORY_PATH,
          icon: 'folder'
        },
        {
          name: 'Tagi',
          path: TEST_PATH,
          icon: 'label'
        },
        {
          name: 'Ulubione',
          path: '',
          icon: 'favorite'
        }
      ]
    },
    {
      group: 'Zarządzanie',
      items: [
        {
          name: 'Kategorie',
          path: '',
          icon: 'folder'
        },
        {
          name: 'Przepisy',
          path: '',
          icon: 'assignment'
        },
        {
          name: 'Tagi',
          path: '',
          icon: 'label'
        }
      ]
    }
  ];
}
