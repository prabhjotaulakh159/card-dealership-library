package com.dealer.models.people;

import com.dealer.models.Location;

/**
 * Employee that can work at a location and make appointments
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Employee extends Person {
    private Location location;
    private int salary;
    
    /**
     * Constructor
     * @param name Name of the employee
     * @param location Where the employee works
     * @param salary Salary of the employee
     * @throws IllegalArgumentException If name is empty/null or location is 
     * null or salary is negative 
     */
    public Employee(String name, String phone, Location location, int salary) {
        super(name, phone); 
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for location
     * @return Where the employee works
     */
    public Location getLocation() {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    /**
     * Mutator for location
     * @param location Where the employee works
     * @throws IllegalArgumentException If location is null
     */
    public void setLocation(Location location) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    /**
     * Accessor for salary
     * @return Salary of the employee
     */
    public int getSalary() {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    /**
     * Mutator for salary
     * @param salary Salary of the employee
     * @throws IllegalArgumentException If salary is negative
     */
    public void setSalary(int salary) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
