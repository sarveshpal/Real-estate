import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';
import {ActivatedRoute,ParamMap} from '@angular/router';
import {AppService} from '../app.services';
import { SubmitDetails } from '../submitproperty/submit';
@Component({
  selector: 'app-property-detail',
  templateUrl: './property-detail.component.html',
  styleUrls: ['./property-detail.component.css'],
  providers:[AppService]
})
export class PropertyDetailComponent implements OnInit {
property:SubmitDetails;
parking:boolean;
ac:boolean;

water:boolean;

storage:boolean;
gaspipe:boolean;
alarm:boolean;
display:boolean=true;
  constructor(private service:AppService,private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap
    .switchMap((params: ParamMap) => this.service.getproperty(+params.get('id')))
    .subscribe(id => {this.property = id;this.checkFeatures();});
  }

  checkFeatures(){

    if(this.property.type=="Garage" || this.property.type=="Commercial Plot" || this.property.type=="Agricultural Plot"){
      this.display=false;
    }
    else{
    //if(this.property.super==true){
    //  this.super=true;
    //}
    if(this.property.parking==true){
      this.parking=true;
    }
    if(this.property.ac==true){
      this.ac=true;
    }
   // if(this.property.pool==true){
     // this.pool=true;
    //}
    if(this.property.storage==true){
      this.storage=true;
    }
    if(this.property.gaspipe==true){
      this.gaspipe=true;
    }
    if(this.property.alarm==true){
      this.alarm=true;
    }
   // if(this.property.laundry==true){
     // this.laundry=true;
    //}
    //if(this.property.pooja==true){
      //this.pooja=true;
    //}
   
  }

}
}
