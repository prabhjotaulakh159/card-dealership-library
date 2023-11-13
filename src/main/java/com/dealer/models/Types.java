package com.dealer.models;

/**
 * Defines default types of cars
 * @author Prabhjot Aulakh
 */
public enum Types {
    CAR("Car"),
    ELECTRIC("Electric"),
    RV("Recreational");

    private final String type;

    private Types(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
