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
        if (employee == null) throw new IllegalArgumentException("Employee cannot be null");
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        if (location == null) throw new IllegalArgumentException("Location cannot be null");
        if (car == null) throw new IllegalArgumentException("Car cannot be null");

        this.employee = employee;
        this.customer = customer;
        this.location = location;
        this.car = car;
    }

    /**
     * Accessor for employee
     * @return Person who made the sale
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Mutator for employee
     * @param Person who made the sale
     * @throws IllegalArgumentException If employee is null
     */
    public void setEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee cannot be null");
        this.employee = employee;
    }

    /**
     * Accessor for customer
     * @return Person who bought the car
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Mutator for customer
     * @param customer Person who bought the car
     * @throws IllegalArgumentException If customer is null
     */
    public void setCustomer(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        this.customer = customer;
    }

    /**
     * Accessor for location
     * @return Location of the sale
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Mutator for location
     * @param location Location of the sale
     * @throws IllegalArgumentException If location is null
     */
    public void setLocation(Location location) {
        if (location == null) throw new IllegalArgumentException("Location cannot be null");
        this.location = location;    }

    /**
     * Accessor for car
     * @return The car that was sold
     */
    public Car getCar() {
        return this.car;
    }

    /**
     * Mutator for car
     * @param car Car that was sold
     * @throws IllegalArgumentException If car is null 
     */
    public void setCar(Car car) {
        if (car == null) throw new IllegalArgumentException("Car cannot be null");
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sale)) {
            return false;
        }
        Sale s = (Sale) o;
        return this.employee.equals(s.employee) &&
               this.customer.equals(s.customer) &&
               this.location.equals(s.location) &&
               this.car.equals(s.car);
    }
}
