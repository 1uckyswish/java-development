package com.pluralsight.InterfaceExample;

public class Car implements MakesNoise{

    @Override
    public void makeNoise() {
        System.out.println("beep beep vrooom vroooommm");
    }
}
