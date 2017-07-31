package com.example.admin.mytourguide;

/**
 * Created by Admin on 7/28/2017.
 */

public class tour {
    String head;
    String description;
    String photoUrl;
    String Address;
    String hours;
    String phone;

    public String getAddress(){return Address;}

    public String getHours(){return hours;}

    public String getPhone(){return phone;}

    public tour (String address,String head, String description, String phone,String photoUrl,String hours){
        this.Address= address;
        this.head=head;
        this.description=description;
        this.phone=phone;
        this.photoUrl=photoUrl;
        this.hours=hours;
    }

    public String getPhotoUrl(){return photoUrl;}

    public String getHead(){return head;}

    public tour (){

    }
    public String getDescription(){return description;}

    public tour (String head, String description,String photoUrl){
        this.head= head;
        this.description=description;
        this.photoUrl=photoUrl;
    }

}
