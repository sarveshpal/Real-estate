import { Component, OnInit } from '@angular/core';
import {SubmitDetails} from '../submitproperty/submit'
import {AppService} from '../app.services'
import {Signup} from '../signup/signup'
import 'rxjs/add/operator/switchMap';
import {ActivatedRoute,ParamMap} from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-myproperty',
  templateUrl: './myproperty.component.html',
  styleUrls: ['./myproperty.component.css'],
  providers:[AppService]
})
export class MypropertyComponent implements OnInit {
   iproperty:SubmitDetails[]=[];
   iproperty1:SubmitDetails;
  sign:Signup;
   a:any;
  iproperty2:SubmitDetails[]=[];
  submitted:boolean;
  deleted:boolean;
  id:number=0;
display:boolean=true;
deactivate:boolean;
     constructor(private service:AppService,private route: ActivatedRoute) {
      
      }
  
   ngOnInit():void{
   this.service.getdetail1()
   .subscribe(l1=>{
      this.iproperty=l1;
      this.propertydetail();
    }); 

    this.route.paramMap
    .switchMap((params: ParamMap) => this.service.get(+params.get('id')))
    .subscribe(id => {this.sign = id});

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

  propertydetail(){
    var j=0;
    for(var i=0;i<this.iproperty.length;i++){
      if(this.iproperty[i].pd.id===this.sign.id){
        this.iproperty2[j]=this.iproperty[i];
        j++;
      }
    
    }
  }
  
  edit1(x:number){
  for(var i=0;i<this.iproperty2.length;i++)
    {
      
      if(this.iproperty2[i].propId==x)
      {    
        this.display=true;
        this.iproperty1=this.iproperty2[i];
        if(this.iproperty1.type=="Garage" || this.iproperty1.type=="Agriculture Plot" || this.iproperty1.type=="Commercial Plot"){
          this.display=false;
        }
      }
    }
  this.a=1;
  }
  
  edit(y){
    this.deleted=false;
  
 
  this.service.update1(y,this.iproperty1.propId).subscribe(t => {this.ngOnInit()});
  
  this.submitted=true;
  }

  delete1(id){
    console.log(id);
    this.id=id;
  }
  
  delete(id){
    console.log(id);
    this.deactivate=false;
    for(var i=0;i<this.iproperty2.length;i++){
      if(this.iproperty2[i].propId===id){
        if(this.iproperty2[i].propertyStat=="ACTIVE"){
          this.deactivate=true;
       this.service.deletedetail(id).subscribe(t => {this.ngOnInit();});
      }
      else if(this.iproperty2[i].propertyStat=="DEACTIVE"){
        this.deactivate=false;
        this.service.enabledetail(id).subscribe(t => {this.ngOnInit();});
      }
    }
  }
  
}
}
