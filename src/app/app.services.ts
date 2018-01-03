import {Injectable} from '@angular/core';
import { Http , Response,Headers,RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';//for mapping
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import {Router} from '@angular/router';
import {Signup} from './signup/signup';
import {Login} from './login/login'
import{SubmitDetails} from './submitproperty/submit';
import {Home} from './home/home';

@Injectable()
export class AppService{
// private url="https://peaceful-fjord-86289.herokuapp.com/addpersonaldetail";
// //private url1="https://peaceful-fjord-86289.herokuapp.com/addpropertydetail";
// private retrieveurl="https://peaceful-fjord-86289.herokuapp.com/getpersonaldetail";
// private retrieveurl1="https://peaceful-fjord-86289.herokuapp.com/getpropertydetail";
// private otpurl="https://peaceful-fjord-86289.herokuapp.com/otp";
// private forgetpasswordurl="https://peaceful-fjord-86289.herokuapp.com/Forgetpassword";
private url="http://localhost:8080/addpersonaldetail";
//private url1="http://localhost:8080/addpropertydetail";
private retrieveurl="http://localhost:8080/getpersonaldetail";
private retrieveurl1="http://localhost:8080/getpropertydetail";
private otpurl="http://localhost:8080/otp";
private forgetpasswordurl="http://localhost:8080/Forgetpassword";

constructor(private http:Http,private router:Router){}

getdetail():Observable<Signup[]>{
    return this.http.get(this.retrieveurl)
      .map((response:Response) => <Response> response.json())
      .catch(this.handleError);
}

getdetail1():Observable<SubmitDetails[]>{
    return this.http.get(this.retrieveurl1)
      .map((response:Response) => <SubmitDetails[]> response.json())
      .catch(this.handleError);
}

get(id:number):Observable<Signup>{
    return this.getdetail().map(user=>user.find(u=>u.id===id))
}
getLocation(location:String):Observable<SubmitDetails>{
    return this.getdetail1().map(user=>user.find(u=>u.location===location))
}

getproperty(id:number):Observable<SubmitDetails>{
    return this.getdetail1().map(user=>user.find(u=>u.propId===id))
}

// getLocationList(location:String):Observable<SubmitDetails>{
//     return this.http.get("http://localhost:8080/getLocationList"+location)
//     .map((response:Response) => <SubmitDetails[]> response.json())
//     .do(data => console.log(JSON.stringify(data)))
//     .catch(this.handleError);
// }

post(sign:Signup):Observable<Response>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.post(this.url,JSON.stringify(sign),opts)
    .map(() => null)
    .catch(this.handleError);
}

post1(sign:SubmitDetails,id:number):Observable<Response>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.post("http://localhost:8080/addpropertydetail/"+id,JSON.stringify(sign),opts);

}

loggedin(l:Login,s1:Signup[]){
    var authuser=s1.find(user1=>user1.username===l.username);
    if(authuser && authuser.password===l.password){
        localStorage.setItem("user","authuser");
        if(authuser.stat=="seller"){
            this.router.navigate(['/seller',authuser.id]);
        }
        else if(authuser.stat=="buyer"){
           this.router.navigate(['/buyer',authuser.id]); 
        }
        return true;
    }
    return false;
}
callotp(signdata:Signup):Observable<Response>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.post(this.otpurl,JSON.stringify(signdata),opts);

}
forgetpassword(data:Signup):Observable<Response>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.post(this.forgetpasswordurl,JSON.stringify(data),opts);

}
logout(){
    localStorage.removeItem("user");
    this.router.navigate(['/Login']);
}

checkcredentials(){
   

    if(localStorage.getItem("user")==null){
        this.router.navigate(['/Login']);
    }
    // else{

    //     localStorage.setItem("authuser","user");
    //     if(authuser.stat=="seller"){
    //         this.router.navigate(['/seller',authuser.id]);
    //     }
    //     else if(authuser.stat=="buyer"){
    //        this.router.navigate(['/buyer',authuser.id]); 
    //     }
    // }
    
}

pricingnavigate(){
    if(localStorage.getItem("user")==null){
        this.router.navigate(['/Login']);
    }
    else{
        this.router.navigate(['/payment'])
    }
}

// update(data:Signup,id:number):Observable<Signup>{
//     let headers=new Headers({'Content-Type':'application/json'});
//     let opts=new RequestOptions({headers:headers});
//     return this.http.put("https://peaceful-fjord-86289.herokuapp.com/updatepassword/"+id.toString(),JSON.stringify(data),opts)
//     //.map(this.extractData)
//     .catch(this.handleError);
//    }
update(password:Signup,id:number):Observable<Signup>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.put("http://localhost:8080/updatepassword/"+id.toString(),JSON.stringify(password),opts)
    //.map(this.extractData)
    .catch(this.handleError);
   }
   update1(property:SubmitDetails,id):Observable<SubmitDetails>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.put("http://localhost:8080/updatepropertydetail/"+id.toString(),JSON.stringify(property),opts)
    //.map(this.extractData)
    .catch(this.handleError);
   }

   deletedetail(prop:number){
       return this.http.delete("http://localhost:8080/deletepropertydetail/"+prop)
            .map(() => null)
            .catch(this.handleError);
   }
   enabledetail(prop:number){
    return this.http.delete("http://localhost:8080/enablepropertydetail/"+prop.toString())
         .map(() => null)
         .catch(this.handleError);
}

private handleError(error:Response){
      console.error(error);
      return Observable.throw(error.json().error());
      
   }
}