package com.dealer.models.cars;

import com.dealer.models.Location;
import com.dealer.models.Promotion;

/**
 * Basic description of Cars
 * @Author Prabhjot Aulakh, Safin Haque
 */
public class Car {
    private String model;
    private int year;
    private String color;
    private Promotion promotion;
    private int price;


    /**
     * Car Constructor
     * @param model car model
     * @param year year car model was made
     * @param color color of car
     * @param promotion if car has promotion
     * removed it
     * @param price price of Car
     * @param IllegalArgumentException if any value is null
     */
    public Car(String model, int year, String color, Promotion promotion, int price){

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
        this.promotion= promotion;
        this.price= price;
    }

    private Exception newIllegalArgumentException() {
        return null;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if(model ==  null || model.isEmpty()){
            throw new IllegalArgumentException("Model value null or is empty, try again");
        }
        this.model= model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if(year<1999){
            throw new IllegalArgumentException("made before 1999, enter another year");
        }
        this.year= year;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if(color ==  null || color.isEmpty()){
            throw new IllegalArgumentException("Color value null or is empty, try again");
        }
    }

    public Promotion getPromotion() {
        return this.promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion= promotion;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        if(price<0){
            throw new IllegalArgumentException("Price is negative, try again ");
        }
        this.price= price;
    }

    @Override
    public boolean equals(Object o){
        Car c2= (Car) o;

        if(this.model == c2.model && this.year == c2.year && this.color== c2.color && this.promotion == c2.promotion &&
        this.price == c2.price){
            return true;
        }
       return false;
    }
}   
