package com.dealer.models.cars;

import com.dealer.models.Location;


/**
 * RecreationalVehicle is a type of Car
 */
public class RecreationalVehicle extends Car {
    private int maxPassengers;
    private int numberOfBeds;
    private boolean hasKitchen;

    /**
     * RecreationalVehicle Constructor
     * @param model car model
     * @param year year car model was made
     * @param color color of car

     * @param location dealership location where car is
     * @param price price of Car
     * @param maxPassengers max amount of people that can be in R.V
     * @param numberOfBeds max beds inside the R.V
     * @param hasKitchen if they have one or not
     */
    public RecreationalVehicle(String model, int year, String color, int price, int maxPassengers, int numberOfBeds, boolean hasKitchen){
        super(model, year, color, price);
        if(maxPassengers <=0){
            throw new IllegalArgumentException("Max passengers is negative or 0, enter again");
        }
        if(numberOfBeds<=0){
            throw new IllegalArgumentException("Number of beds is negative or 0, enter again");
        }

        this.maxPassengers= maxPassengers;
        this.numberOfBeds= numberOfBeds;
        this.hasKitchen= hasKitchen;
    }

    /**
     * Acessor of MaxPassengers
     * @return the max number of passengers that fir in R.V
     */
    public int getMaxPassengers() {
        return this.maxPassengers;
    }

    /**
     * Mutator for MaxPassengers
     * @param maxPassengers the max passengers hat fit in R.V
     */
    public void setMaxPassengers(int maxPassengers) {
        if(maxPassengers <=0){
            throw new IllegalArgumentException("Max passengers is negative or 0, enter again");
        }
        this.maxPassengers= maxPassengers;
    }

    /**
     * Acessor of NumberOfBeds
     * @return number of beds in R.V
     */
    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    /**
     * Mutator of numberOfBeds
     * @param numberOfBeds the number of beds in R.V
     */
    public void setNumberOfBeds(int numberOfBeds) {
        if(numberOfBeds<=0){
            throw new IllegalArgumentException("Number of beds is negative or 0, enter again");
        }
        this.numberOfBeds= numberOfBeds;
    }

    /**
     * Acessor of Has Kitchen
     * @return true or false if they have a Kitchen or not in R.V
     */
    public boolean isHasKitchen() {
        return this.hasKitchen;
    }

    /**
     * Mutator of hasKitchen
     * @param hasKitchen true or false if they have a kitchen or not
     */
    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen=hasKitchen;
    }

    @Override
    public boolean equals(Object o){

        if(!(o instanceof Car)){
            return false;
        }
        RecreationalVehicle rv = (RecreationalVehicle) o;

        return this.getModel() == rv.getModel() && this.getColor() == rv.getColor()
        && this.getYear() == rv.getYear() && this.getPrice() == rv.getPrice() && this.getMaxPassengers() == rv.getMaxPassengers()
        && this.getNumberOfBeds() == rv.getNumberOfBeds() && this.isHasKitchen() == rv.isHasKitchen();
    }
    


}
