package com.arunapi.observer.example;

import com.arunapi.observer.structure.Observer;
import com.arunapi.observer.structure.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FoodTruck implements Subject {
    private List<Customer> customers;
    private String status;
    private HashMap<String,List<Customer>> customerMap;

    public FoodTruck(){
        customers = new ArrayList<>();
        customerMap = new HashMap<>();
    }

    public void attach(Observer o){
        customers.add((Customer) o);
    }


    public void attach(Observer o, String aspect){
        List<Customer> customerList = customerMap.get(aspect)!=null?
                customerMap.get(aspect): new ArrayList<>();

        customerList.add((Customer) o);
        customerMap.put(aspect,customerList);
    }
    public void detach(Observer o){

    }
    public void notifyObservers(){
        for (Observer o : customers){
            o.update(this);
        }
    }

    public void placeOrder(Customer customer) {
        attach(customer);
    }

    public void placeOrder(Customer customer, String menuItem) {
        attach(customer,menuItem);
    }
    public List<Customer> getCustomers() {
        return customers;
    }

    public String getStatus() {
        return status;
    }

    public void callCustomersWhenFoodIsReady() {
        this.status = "READY_FOR_PICKUP";
        notifyObservers();
    }

    public void callPizzaCustomersWhenPizzaIsReady() {
        this.status = "READY_FOR_PICKUP";
        notifyObservers("PIZZA");
    }

    private void notifyObservers(String aspect) {
        for(Observer o : customerMap.get(aspect)){
            o.update(this);
        }
    }
}
