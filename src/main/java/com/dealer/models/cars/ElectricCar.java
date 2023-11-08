package com.dealer.models;


/**
 * ElectricCar is a type of Car
 */
public class ElectricCar extends Car {
    private int Voltage;
    private String chargerType;

    /**
     * ElectricCar Constructor
     * @param model car model
     * @param year year car model was made
     * @param color color of car
     * @param promotion if car has promotion
     * @param location dealership location where car is
     * @param price price of Car
     * @param voltage the amount of volts they have
     * @param chargerType the type of charger they need
     */
    public ElectricCar(String model, int year, String color, Promotion promotion, Location location, int price, int voltage, String ChargerType){
        super(model, year, color, promotion, location, price);
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Acess the voltage
     * @return amount of voltage the car hads 
     */
    public int getVoltage() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for the Voltage
     * @param voltage
     */
    public void setVoltage(int voltage) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Acess the chargerType
     * @return name of chargerType
     */
    public String getChargerType() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for the chargerType
     * @param chargerType
     */
    public void setChargerType(String chargerType) {
        throw new UnsupportedOperationException("not implemented");
    }

    
}
