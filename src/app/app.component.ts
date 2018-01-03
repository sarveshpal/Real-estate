import { Component } from '@angular/core';
import {AppService} from './app.services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[AppService]
})
export class AppComponent {
  title = 'app';
navbarChange:boolean;

constructor(private service:AppService){}

  ngOnInit(){
    // this.navbarChange=
    // console.log(this.navbarChange);
}

// myDashboard(){
//   this.service.checkcredentials();
// }

}