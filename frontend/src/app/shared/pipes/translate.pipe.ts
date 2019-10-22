import { TranslateService } from './../../service/translate/translate.service';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'translate',
  pure: false
})
export class TranslatePipe implements PipeTransform {

  constructor(private _translateSerice: TranslateService) {
  }

  transform(key: any): any {
    return this._translateSerice.data[key] || key;
  }
}
