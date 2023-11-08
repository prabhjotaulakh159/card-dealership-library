package com.dealer.models;

import java.util.List;

import com.dealer.models.cars.Car;

/**
 * Location of a dealership
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Location {
    private String address;
    private String branch;
    private List<Car> cars;
    
    /**
     * Constructor
     * @param address Address of location
     * @param branch Name of the the location
     * @param cars Cars within the location
     * @throws IllegalArgumentException If any of fields are null
     */
    public Location(String address, String branch, List<Car> cars) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for address
     * @return Address of the location
     */
    public String getAddress() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Mutator for address
     * @param address Address of the location 
     * @throws IllegalArgumentException If address is empty or null
     */
    public void setAddress(String address) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for branch
     * @return Name of the location
     */
    public String getBranch() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Mutator for branch
     * @param branch Name of the location
     * @throws IllegalArgumentException If branch is empty or null
     */
    public void setBranch(String branch) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for cars
     * @return All cars within the location
     */
    public List<Car> getCars() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Mutator for cars
     * @param cars List of cars
     * @throws IllegalArgumentException If cars is null
     */
    public void setCars(List<Car> cars) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
