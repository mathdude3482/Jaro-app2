/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
public class Inventory {
    private String name;
    private String serialNumber;
    private double value;


    public Inventory(String name, String serialNumber, double value) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }
    //this class will contain only set and get methods for each part of an item.
    public void setName(String name){
        //set the name of the item.
        this.name = name;
    }
    public void setSerial(String serialNumber){
        //set the Serial number of the item.
        this.serialNumber = serialNumber;
    }
    public void setValue(double value){
        //set the value of the item.
        this.value = value;
    }
    public String getName(){
        //get the name of the item.
        return name;
    }
    public String getSerial(){
        //get the Serial number of the item.
        return serialNumber;
    }
    public double getValue(){
        //get the value of the item.
        return value;
    }
}
