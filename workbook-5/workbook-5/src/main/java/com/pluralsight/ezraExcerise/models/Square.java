package com.pluralsight.ezraExcerise.models;

public class Square extends Rectangle{
    private double length;
    private double width;
    public Square(double sameSide){
        super(sameSide,sameSide);
    }

    @Override
    public double getArea(){
        //Variables from superclass rectangle since they are protected they can be passed down
        if(length == width){
            //Get the superclass method to calculate length * height
            //Instead of doing length * height;
            return super.getArea();
        }else{
            System.out.println("The measurements given are not a square");
            return 0.0;
        }
    }
}
