import { FrontCarouselService } from './../../service/front-carousel/front-carousel.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-front-carousel',
  templateUrl: './front-carousel.component.html',
  styleUrls: ['./front-carousel.component.scss'],
  providers: [FrontCarouselService]
})
export class FrontCarouselComponent implements OnInit {

  slides = [];

  slideConfig = {
    'slidesToShow': 1,
    'slidesToScroll': 1,
    'arrows': false,
    'autoplay': true,
    'autoplaySpeed': 5000,
    'dots': false,
    'speed': 2000,
    'cssEase': 'ease-in-out',
    'infinite': true,
    'draggable': false
  };

  constructor(private _frontCarouselService: FrontCarouselService) {
  }

  ngOnInit() {
    this._frontCarouselService.getSlides().subscribe(
      data => {
        this.slides = data;
      },
      error => {
        console.error(error);
      }
    );
  }
}
