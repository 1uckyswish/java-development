package com.pluralsight.GenericsExample;
//Make a class with dimaond operetar. it hold a unkown data type
//Can be called anything but we use T
public class Printer <T> {
    //T will be the data type until its known
    T thingToPrint;

    //Call the constructor
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    //print the value
    public void print(){
        System.out.println(thingToPrint);
    }
}
