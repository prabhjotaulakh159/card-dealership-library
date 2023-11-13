package com.dealer.models.cars;

/**
 * Basic description of Cars
 * @Author Prabhjot Aulakh, Safin Haque
 */
public class Car {
    private String model;
    private int year;
    private String color;
    private int price;


    /**
     * Car Constructor
     * @param model car model
     * @param year year car model was made
     * @param color color of car
     * @param promotion if car has promotion
     * removed it
     * @param price price of Car
     * @throws IllegalArgumentException if any value is null
     */
    public Car(String model, int year, String color, int price){

        if(model ==  null || model.isEmpty()){
            throw new IllegalArgumentException("Model value null or is empty, try again");
        }
        if(color ==  null || color.isEmpty()){
            throw new IllegalArgumentException("Color value null or is empty, try again");
        }
        if(year<1999){
            throw new IllegalArgumentException("made before 1999, enter another year");
        }
        if(price<0){
            throw new IllegalArgumentException("Price is negative, try again ");
        }
        this.model = model;
        this.year= year;
        this.color= color;
        this.price= price;
    }

   
    /**
     * Access car model
     * @return model name
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Mutator for Model
     * @param model A string of the car model
     */
    public void setModel(String model) {
        if(model ==  null || model.isEmpty()){
            throw new IllegalArgumentException("Model value null or is empty, try again");
        }
        this.model= model;
    }

    /**
     * Accessing Years
     * @return The car Year 
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Mutator for Year
     * @param year the Car Year
     */
    public void setYear(int year) {
        if(year<1999){
            throw new IllegalArgumentException("made before 1999, enter another year");
        }
        this.year= year;
    }

    /**
     * Accessor of Car Color
     * @return Color of car in String
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Mutator of Color
     * @param color a String holding the car color
     */
    public void setColor(String color) {
        if(color ==  null || color.isEmpty()){
            throw new IllegalArgumentException("Color value null or is empty, try again");
        }
    }


    
    /**
     * Accessor of Price
     * @return the Car Price
     */
    public int getPrice() {
        return this.price;
    }
    
    /**
     * Mutator of Price
     * @param price price we want to set a car to
     */
    public void setPrice(int price) {
        if(price<0){
            throw new IllegalArgumentException("Price is negative, try again ");
        }
        this.price= price;
    }

    /**
     * The equals Method to check 2 car objects
     * @returns true or false
     */
    @Override
    public boolean equals(Object o){
        Car c2= (Car) o;

        if(this.model == c2.model && this.year == c2.year && this.color== c2.color &&
        this.price == c2.price){
            return true;
        }
       return false;
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + ", color=" + color + ", price=" + price + "]";
    }
}   
