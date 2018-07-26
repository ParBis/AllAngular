import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { enableProdMode } from '@angular/core';
// import { appModuleName } from './path/fileName.component';
import {AppModule} from './app.module'

//enableProdMode(); //Uncomment for production
platformBrowserDynamic().bootstrapModule(AppModule);