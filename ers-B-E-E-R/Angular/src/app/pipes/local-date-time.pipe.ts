import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';

@Pipe({
  name: 'localDateTime'
})
export class LocalDateTimePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (!value) {
      return '';
    }
    const date = `${value.dayOfMonth}/${value.month}/${value.year} [${value.hour}:${value.minute}]`;
    return date;
  }
}
