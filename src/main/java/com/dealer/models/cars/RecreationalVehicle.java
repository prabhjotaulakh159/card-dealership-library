package com.dealer.models;

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
     * @param promotion if car has promotion
     * @param location dealership location where car is
     * @param price price of Car
     * @param maxPassengers max amount of people that can be in R.V
     * @param numberOfBeds max beds inside the R.V
     * @param hasKitchen if they have one or not
     */
    public RecreationalVehicle(String model, int year, String color, Promotion promotion, Location location, int price, int maxPassengers, int numberOfBeds, boolean hasKitchen){
        super(model, year, color, promotion, location, price);
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Acessor of MaxPassengers
     * @return the max number of passengers that fir in R.V
     */
    public int getMaxPassengers() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for MaxPassengers
     * @param maxPassengers the max passengers hat fit in R.V
     */
    public void setMaxPassengers(int maxPassengers) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Acessor of NumberOfBeds
     * @return number of beds in R.V
     */
    public int getNumberOfBeds() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator of numberOfBeds
     * @param numberOfBeds the number of beds in R.V
     */
    public void setNumberOfBeds(int numberOfBeds) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Acessor of Has Kitchen
     * @return true or false if they have a Kitchen or not in R.V
     */
    public boolean isHasKitchen() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator of hasKitchen
     * @param hasKitchen true or false if they have a kitchen or not
     */
    public void setHasKitchen(boolean hasKitchen) {
        throw new UnsupportedOperationException("not implemented");
    }

    


}
