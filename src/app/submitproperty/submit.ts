export class SubmitDetails
{   
    propId:number;
    title:String;
    propStatus:String;
    type:String;
    price:number;
    area:number;
    //rooms:number;
    //bathroom:number;
    address:String;
    //postalcode:number;
    info:String;
    name:String;
    email:String;
    phone:number;
    parking:boolean=false;
    ac:boolean=false;
    carpet:number;
    super:number;
    washroom:number;
    //balcony:boolean=false;
    //pool:boolean=false;
    storage:boolean=false;
    gaspipe:boolean=false;
    alarm:boolean=false;
    water:boolean=false;
    building:String;
    //pooja:boolean=false;
    //laundry:boolean=false;
   // city:String;
    //state:String;
   //buildingage:String;
    floor:String;
   // noofparking:String;
    furnished:String;
    //view:String;
    pd:any;
    location:String;
    //image:any;
    propertyStat:String="activate";
constructor(title,propStatus,type,price,area,location,superarea,carpetarea,info,building,floor,parking,furnished,
washroom,water,ac,storage,gaspipe,alarm,name,email,phone,propertyStat)
        {
            this.name=name;
            this.email=email;
            this.propStatus=propStatus;
            this.carpet=carpetarea;
            this.super=superarea;
            this.type=type;
            this.water=water;
            //this.rooms=rooms;
            //this.bathroom=bathroom;
            this.title=title;
            this.price=price;
            this.area=area;
            // this.address=address;
            //this.postalcode=postalcode;
            this.phone=phone;
            this.info=info;
            this.parking=parking;
            this.ac=ac;
            //this.balcony=balcony;
            //this.pool=pool;
            this.storage=storage;
            this.gaspipe=gaspipe;
            this.alarm=alarm;
            this.building=building;
            //this.pooja=pooja;
            //this.laundry=laundry;
            //this.city=city;
            //this.state=state;
            //this.buildingage=buildingage;
            this.floor=floor;
            // this.noofparking=noofparking;
            this.furnished=furnished;
            //this.view=view;
            this.location=location;
            //this.image=image;
            this.propertyStat=propertyStat;
        }
    }