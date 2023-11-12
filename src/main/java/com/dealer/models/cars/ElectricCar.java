package com.dealer.models.cars;

import com.dealer.models.Location;
import com.dealer.models.Promotion;

/**
 * ElectricCar is a type of Car
 */
public class ElectricCar extends Car {
    private int voltage;
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
    public ElectricCar(String model, int year, String color, Promotion promotion, int price, int voltage, String ChargerType){
        super(model, year, color, promotion, price);
        if(voltage<=0){
            throw new IllegalArgumentException("Voltage is negative or equals to 0, try again");
        }
        if(chargerType == null || chargerType.isEmpty()){
            throw new IllegalArgumentException("Charger Type is null or empty");
        }
        this.voltage= voltage;
        this.chargerType= ChargerType;
    }

    /**
     * Acess the voltage
     * @return amount of voltage the car hads 
     */
    public int getVoltage() {
        return this.voltage;
    }

    /**
     * Mutator for the Voltage
     * @param voltage
     */
    public void setVoltage(int voltage) {
        if(voltage<=0){
            throw new IllegalArgumentException("Voltage is negative or equals to 0, try again");
        }
        this.voltage= voltage;
    }

    /**
     * Acess the chargerType
     * @return name of chargerType
     */
    public String getChargerType() {
        return this.chargerType;
    }

    /**
     * Mutator for the chargerType
     * @param chargerType
     */
    public void setChargerType(String chargerType) {
       if(chargerType == null || chargerType.isEmpty()){
            throw new IllegalArgumentException("Charger Type is null or empty");
        }
        this.chargerType= chargerType;
    }

    @Override
    public boolean equals(Object o){
        ElectricCar ec2= (ElectricCar) o;

        if(this.voltage == ec2.voltage && this.chargerType== ec2.chargerType && super.equals(o)){
            return true;
        }
       return false;
    }
}
