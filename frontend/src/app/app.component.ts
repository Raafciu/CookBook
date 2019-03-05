import {Component} from "@angular/core";
import {fadeAnimation} from "./shared/animations/animations";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  animations: [fadeAnimation]
})
export class AppComponent {

}
