package com.arunapi.observer.structure;

public interface Subject {

    public void attach(Observer o);
    public void attach(Observer o, String aspect);
    public void detach(Observer o);
    public void notifyObservers();
}
