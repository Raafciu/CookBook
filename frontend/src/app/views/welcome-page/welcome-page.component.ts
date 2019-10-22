import { MatSidenav } from '@angular/material';
import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.scss']
})
export class WelcomePageComponent {

  @ViewChild('sidenav', { static: false }) sidenav: MatSidenav;

  isMobile: boolean;

  constructor() {
    const screenWidth = window.innerWidth;
    this.isMobile = screenWidth <= 960;
    window.onresize = () => {
      this.isMobile = window.innerWidth <= 960;
    };
  }
}
