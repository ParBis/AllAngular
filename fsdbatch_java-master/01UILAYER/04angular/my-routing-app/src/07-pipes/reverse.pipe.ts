import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'reverse'
})
export class ReversePipe implements PipeTransform {


    // {{ value | custompipe: args}}
    transform(value: string, args: any) {
        console.log(value);
        return value.split('').reverse().join('');
    }

}