package com.arunapi.observer.example;

import com.arunapi.observer.structure.Observer;
import com.arunapi.observer.structure.Subject;

public class Customer implements Observer {

    private String status;

    public void update(Subject s){
        //FoodTruck has notified
        //Update the status, by reading from subject
        this.status = ((FoodTruck)s).getStatus();
    }

    public String getStatus() {
        return this.status;
    }
}
