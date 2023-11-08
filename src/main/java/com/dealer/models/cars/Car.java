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
    private Location location;
    private int price;


    /**
     * Car Constructor
     * @param model car model
     * @param year year car model was made
     * @param color color of car
     * @param promotion if car has promotion
     * @param location dealership location where car is
     * @param price price of Car
     * @param IllegalArgumentException if any value is null
     */
    public Car(String model, int year, String color, Promotion promotion, Location location, int price){
        throw new UnsupportedOperationException("not implemented");
    }

    public String getModel() {
        throw new UnsupportedOperationException("not implemented");
    }

    public void setModel(String model) {
        throw new UnsupportedOperationException("not implemented");
    }

    public int getYear() {
        throw new UnsupportedOperationException("not implemented");
    }

    public void setYear(int year) {
        throw new UnsupportedOperationException("not implemented");
    }

    public String getColor() {
        throw new UnsupportedOperationException("not implemented");
    }

    public void setColor(String color) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Promotion getPromotion() {
        throw new UnsupportedOperationException("not implemented");
    }

    public void setPromotion(Promotion promotion) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Location getLocation() {
        throw new UnsupportedOperationException("not implemented");
    }

    public void setLocation(Location location) {
        throw new UnsupportedOperationException("not implemented");
    }

    public int getPrice() {
        throw new UnsupportedOperationException("not implemented");
    }

    public void setPrice(int price) {
        throw new UnsupportedOperationException("not implemented");
    }
}   
