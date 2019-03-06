import {Component, HostListener, ViewChild} from "@angular/core";
import {MatSidenav} from "@angular/material";

@Component({
  selector: 'app-home',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  @ViewChild('sidenav') sidenav: MatSidenav;
  opened: boolean;

  close() {
    this.sidenav.close();
  }

  @HostListener('window:resize', ['$event'])
  changeSideNavMode($event) {
    const innerWidth = window.innerWidth;
    if (innerWidth <= 1024) {
      this.opened = false;
      return 'over';
    } else {
      this.opened = true;
      return 'side';
    }
  }
}
