import { Injectable } from '@angular/core';

@Injectable()
export class LogService {

    logs: Array<string> = []
    
    constructor() { }

    log(message: string){
        this.logs.push(message);
    }
    
    fetchLogs(){
        return this.logs
    }

    fetchLogsWithPromise(): Promise <Array<string>> {

       return new Promise((resolve, reject)=> {
            setTimeout(()=>{
                resolve(this.logs)    
            }, 1000)
        })
    }

}