import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { SubmitDetails } from '../submitproperty/submit';
import {AppService} from '../app.services';
import {Home} from './home';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[AppService]
})

export class HomeComponent implements OnInit {
  property:SubmitDetails[]=[];
  propertydetail:SubmitDetails;
  list:SubmitDetails[]=[];

  constructor(private service:AppService,private router:Router) {  }

  ngOnInit() {
    this.service.getdetail1().subscribe(t => {this.property=t});

  }
// search(location){
//   console.log(location);
//   this.location=location;
// }
locationList(formValue){
  this.router.navigate(['/propertyList',formValue.toUpperCase()])
//   var j=0;
// for(var i=0;i<this.property.length;i++){
//     if(this.property[i].location===formValue.location){
//       this.list[j]=this.property[i];
//       j++;
//     }
// }
//  for(var i=0;i<this.list.length;i++){
//    console.log(this.list[i]);
//  }
}
}
