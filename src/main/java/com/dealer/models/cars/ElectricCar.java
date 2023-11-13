package com.dealer.models.cars;

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
     * @throws IllegalArgumentException if any value is null or empty or negative
     * @param location dealership location where car is
     * @param price price of Car
     * @param voltage the amount of volts they have
     * @param chargerType the type of charger they need
     */
    public ElectricCar(String model, int year, String color, int price, int voltage, String chargerType){
        super(model, year, color, price);
        if(voltage<=0){
            throw new IllegalArgumentException("Voltage is negative or equals to 0, try again");
        }
        if(chargerType == null){
            throw new IllegalArgumentException("Charger Type is null");
        }
        else if(chargerType.isEmpty()){
            throw new IllegalArgumentException("Charger Type is empty");
        }
        this.voltage= voltage;
        this.chargerType= chargerType;
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
       if(chargerType == null){
            throw new IllegalArgumentException("Charger Type is null");
        }
        else if(chargerType.isEmpty()){
            throw new IllegalArgumentException("Charger Type is empty");
        }
        this.chargerType= chargerType;
    }

    @Override
    public boolean equals(Object o){
        
        if(!(o instanceof Car)){
            return false;
        }

        ElectricCar electricCar = (ElectricCar) o;

        return this.getModel() == electricCar.getModel() && this.getYear() == electricCar.getYear() && this.getColor() == electricCar.getColor()
         && this.getPrice() == electricCar.getPrice() && this.getVoltage()== electricCar.getVoltage()
        && this.getChargerType()== electricCar.getChargerType();
       
    }
}
