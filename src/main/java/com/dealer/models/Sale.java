package com.dealer.models;

import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

/**
 * A sale made by an employee to a customer at a location
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Sale {
    private Employee employee;
    private Customer customer;
    private Location location;
    private Car car;
    
    /**
     * Constructor
     * @param employee Person who made the sale
     * @param custom Person who bought the car
     * @param location Location of the sale
     * @param car Car that was sold
     * @throws IllegalArgumentException If any of the fields are null
     */
    public Sale(Employee employee, Customer customer, Location location, Car car) {
        throw new UnsupportedOperationException("Not implemented");

    }

    /**
     * Accessor for employee
     * @return Person who made the sale
     */
    public Employee getEmployee() {
        throw new UnsupportedOperationException("Not implemented");

    }

    /**
     * Mutator for employee
     * @param Person who made the sale
     * @throws IllegalArgumentException If employee is null
     */
    public void setEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for customer
     * @return Person who bought the car
     */
    public Customer getCustomer() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Mutator for customer
     * @param customer Person who bought the car
     * @throws IllegalArgumentException If customer is null
     */
    public void setCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for location
     * @return Location of the sale
     */
    public Location getLocation() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Mutator for location
     * @param location Location of the sale
     * @throws IllegalArgumentException If location is null
     */
    public void setLocation(Location location) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for car
     * @return The car that was sold
     */
    public Car getCar() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Mutator for car
     * @param car Car that was sold
     * @throws IllegalArgumentException If car is null 
     */
    public void setCar(Car car) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
