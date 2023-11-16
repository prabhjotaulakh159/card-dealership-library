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
     * Constructor
     * @param model Model of the car
     * @param year Year of the car
     * @param color Color of the car
     * @param price Price of the Car
     * @throws IllegalArgumentException if any value is null/empty
     */
    public Car(String model, int year, String color, int price){
        if (model == null) 
            throw new IllegalArgumentException("Model cannot be null");
        if (color == null) 
            throw new IllegalArgumentException("Color cannot be null");
        if (model.isEmpty() || model.isBlank()) 
            throw new IllegalArgumentException("Model cannot be blank");
        if (color.isEmpty() || color.isBlank()) 
            throw new IllegalArgumentException("Color cannot be blank");
        if (year < 1999)
            throw new IllegalArgumentException("Year cannot be below 1999");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    /**
     * Accessor for model
     * @return Model of the car
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Mutator for Model
     * @param model A string of the car model
     */
    public void setModel(String model) {
        if(model == null) 
            throw new IllegalArgumentException("Model cannot be null");
        if (model.isEmpty() || model.isBlank()) 
            throw new IllegalArgumentException("Model cannot be blank");
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
        if (year < 1999) 
            throw new IllegalArgumentException("made before 1999, enter another year");
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
        if (color == null) 
            throw new IllegalArgumentException("Color cannot be null");
        if (color.isEmpty() || color.isBlank()) 
            throw new IllegalArgumentException("Color cannot be blank");
        this.color = color;
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
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    /**
     * The equals Method to check 2 car objects
     * @returns true or false
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Car)) 
            return false;
        Car car = (Car) o;
        return this.model.equals(car.model) && this.year == car.year && this.color.equals(car.color) && this.price == car.price;
    }
    
    /**
     * Constructs a string representation for a car
     * @return String representation of a car
     */
    @Override
    public String toString() {
        return this.model + " | " + this.year + " | " + this.color + " | " + this.price + "$";
    }
}   
