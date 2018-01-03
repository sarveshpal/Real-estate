import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.services';
import { SubmitDetails } from '../submitproperty/submit';
import 'rxjs/add/operator/switchMap';
import {ActivatedRoute,ParamMap} from '@angular/router';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css'],
  providers:[AppService]
})

export class PropertyListComponent implements OnInit {

  property:SubmitDetails[]=[];
  list:SubmitDetails[]=[];
  propertydetail:SubmitDetails;

  constructor(private service:AppService,private route:ActivatedRoute) { }


  ngOnInit() {
    
    this.route.paramMap
    .switchMap((params: ParamMap) => this.service.getLocation(params.get('location')))
    .subscribe(property => {
                this.propertydetail = property;
              });

  this.service.getdetail1()
  .subscribe(t => {
    this.property=t;
    this.getPropertyList();
  });
     
}

check(){
  this.service.checkcredentials();
}

getPropertyList(){

  var j=0;
  for(var i=0;i<this.property.length;i++){
    if(this.property[i].location === this.propertydetail.location){
      if(this.property[i].propertyStat==="ACTIVE"){
        this.list[j]=this.property[i];
        j++;
      }
  }
}
}
}

