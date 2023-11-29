package com.dealer.data.models.cars;

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
        if (voltage <= 0)
            throw new IllegalArgumentException("Voltage must be greater than 0");
        if (chargerType == null)
            throw new IllegalArgumentException("Charger Type cannot be null");
        if (chargerType.isEmpty() || chargerType.isBlank())
            throw new IllegalArgumentException("Charger Type is empty");
        this.voltage = voltage;
        this.chargerType = chargerType;
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
        if (voltage <= 0)
            throw new IllegalArgumentException("Voltage must be greater than 0");
        this.voltage= voltage;
    }

    /**
     * Access the chargerType
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
        if (chargerType == null)
            throw new IllegalArgumentException("Charger Type cannot be null");
        if (chargerType.isEmpty() || chargerType.isBlank())
            throw new IllegalArgumentException("Charger Type is empty");
        this.chargerType= chargerType;
    }

    /**
     * Checks if two electric cars are equal
     * @return Whether or not they have the same fields
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Car))
            return false;
        ElectricCar electricCar = (ElectricCar) o;
        return super.equals(o) && this.voltage == electricCar.voltage && this.chargerType.equals(electricCar.chargerType);
    }
    
    /**
     * Constructs a string representation for an electric car
     * @return String representation of an electric car
     */
    @Override
    public String toString() {
        return super.toString() + " | " + this.voltage + " volts | " + this.chargerType;
    }
}
