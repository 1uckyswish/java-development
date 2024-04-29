package com.pluralsight.AbstractAssets;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String descirption, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(descirption, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public double getValue(){
        double extraTax = squareFoot * 0.25;
        if(condition == 1){
            return (180.00 * squareFoot )+ extraTax;
        }else if(condition == 2){
            return (130.00 * squareFoot )+ extraTax;
        }else if(condition == 3){
            return (90.00 * squareFoot )+ extraTax;
        }else if(condition == 4){
            return (80.00 * squareFoot )+ extraTax;
        }else{
            return 0;
        }
    }


}
