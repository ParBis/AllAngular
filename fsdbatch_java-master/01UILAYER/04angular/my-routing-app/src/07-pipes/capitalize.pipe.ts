import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'captialize'
})
export class CapitalizePipe implements PipeTransform {

    transform(value: string, args: number) {
        console.log(args)
        let str = ""
        for(let i=0;i<args; i++){
            str += value[i].toUpperCase() 
        }

       return str + value.slice(args).toLowerCase();
    }

}