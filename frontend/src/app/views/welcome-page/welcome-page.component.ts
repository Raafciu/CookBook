import {Component} from "@angular/core";

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.scss']
})
export class WelcomePageComponent {

  title: string = 'CookBook';
  subtitle: string = 'Twoja e-książka kucharska';
  enterCaption: string = 'Wejdź'.toUpperCase();
  socialIcons: Array<string> = ['dsa', 'dsa'];
  credentials: string = '@Redpike';
}
