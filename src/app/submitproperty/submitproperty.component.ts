import { Component,EventEmitter,Output} from '@angular/core';
import {SubmitDetails}from './submit'
import {AppService} from '../app.services';
import 'rxjs/add/operator/switchMap';
import {ActivatedRoute,ParamMap} from '@angular/router';
import {Signup} from '../signup/signup'
import{Router} from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-submitproperty',
  templateUrl: './submitproperty.component.html',
  styleUrls: ['./submitproperty.component.css' ,
  './../../../node_modules/bootstrap/dist/css/bootstrap.css'],
  providers:[AppService]
})
export class SubmitpropertyComponent{
sign:Signup;
j:boolean;
prop:SubmitDetails;
data:SubmitDetails[];
display:boolean=true;
  constructor(private service:AppService,private route: ActivatedRoute,private router:Router) {
    
}
  ngOnInit(){
    this.service.checkcredentials();

    this.route.paramMap
    .switchMap((params: ParamMap) => this.service.get(+params.get('id')))
    .subscribe(id => {this.sign = id;});

    //console.log(this.sign);

    this.service.getdetail1().subscribe(t => { this.data=t});
  }

  ngAfterViewChecked() {
    // $('.numeridot').keypress(function(key) {
    //     if((key.charCode < 48 || key.charCode > 57) && (key.charCode != 46)) return false;
    // });

    // $('.numeri').keypress(function(key) {
    //     if(key.charCode < 48 || key.charCode > 57) return false;
    // });

    $('.alpha_bet').keypress(function(key) {
        if((key.charCode < 97 || key.charCode > 122) && (key.charCode < 65 || key.charCode > 90) && (key.charCode!=32) && (key.charCode!=45) ) return false;
    });

    $('.mobileNo').keypress(function(key) {
        if(key.charCode < 48 || key.charCode > 57) return false;
    });

  }

newSub(a:SubmitDetails){
 // console.log(a.location.toUpperCase());

  this.prop = new SubmitDetails(a.title,a.propStatus,a.type,a.area,a.price,a.location,a.super,a.carpet,
a.info,a.building,a.floor,a.parking,a.furnished,a.washroom,a.water,a.ac,a.storage,a.gaspipe,a.alarm,a.name,a.email,a.phone,a.propertyStat);

  // this.prop=new SubmitDetails(a.title.toUpperCase(),a.propStatus,a.type,a.price,a.area,a.washroom,
  // a.address.toUpperCase(),a.super,a.carpet,a.water,a.name.toUpperCase(),a.email,a.phone,
  // a.parking,a.ac,a.image,a.storage,a.gaspipe,a.alarm,a.city,a.state,a.buildingage,a.floor,a.noofparking,a.furnished,a.view,a.location.toUpperCase(),a.propertyStat);
    console.log(this.prop);
       this.service.post1(this.prop,this.sign.id).subscribe(t => {this.ngOnInit();});

        this.router.navigate(['/seller',this.sign.id]);

}
checkType(type){
  this.display=true;
  if(type=="Garage" || type=="Agriculture Plot" || type=="Commercial Plot"){
    this.display=false;

  }
  

}
}

