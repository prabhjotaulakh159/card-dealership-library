package com.dealer.models;

import java.util.List;

import com.dealer.models.cars.Car;
import com.dealer.models.people.Employee;

/**
 * Location of a dealership
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Location {
    private String address;
    private String branch;
    private List<Car> cars;
    private List<Employee> employees;
    
    /**
     * Constructor
     * @param address Address of location
     * @param branch Name of the the location
     * @param cars Cars within the location
     * @throws IllegalArgumentException If any of fields are null
     */
    public Location(String address, String branch, List<Car> cars, List<Employee> employees) {
        if(address== null){
            throw new IllegalArgumentException("Adress is null, try again");
        }else 
        if(address.isEmpty()){
            throw new IllegalArgumentException("Adress is empty, try again");
        }
        if(branch== null){
            throw new IllegalArgumentException("Branch is null, try again");
        }else 
        if(branch.isEmpty()){
            throw new IllegalArgumentException("Branch is empty, try again");
        }
        if(cars == null){
            throw new IllegalArgumentException("List of cars is null");
        }
        if(employees == null){
            throw new IllegalArgumentException("List of Employees is null");
        }

        this.address= address;
        this.branch= branch;
        this.cars= cars;
        this.employees= employees;
    }

    /**
     * Accessor for address
     * @return Address of the location
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Mutator for address
     * @param address Address of the location 
     * @throws IllegalArgumentException If address is empty or null
     */
    public void setAddress(String address) {
         if(address== null){
            throw new IllegalArgumentException("Adress is null, try again");
        }else 
        if(address.isEmpty()){
            throw new IllegalArgumentException("Adress is empty, try again");
        }
        this.address= address;
    }


    /**
     * Accessor for branch
     * @return Name of the location
     */
    public String getBranch() {
        return this.branch;
    }

    /**
     * Mutator for branch
     * @param branch Name of the location
     * @throws IllegalArgumentException If branch is empty or null
     */
    public void setBranch(String branch) {
        if(branch== null){
            throw new IllegalArgumentException("Branch is null, try again");
        }

        if(branch.isEmpty()){
            throw new IllegalArgumentException("Branch is empty, try again");
        }
        this.branch= branch;
    }

    /**
     * Accessor for cars
     * @return All cars within the location
     */
    public List<Car> getCars() {
        return this.cars;
    }

    /**
     * Mutator for cars
     * @param cars List of cars
     * @throws IllegalArgumentException If cars is null
     */
    public void setCars(List<Car> cars) {
        if(cars == null){
            throw new IllegalArgumentException("List of cars is null");
        }
        this.cars= cars;
    }

    /**
     * Accessor for employees
     * @return list of employees who work at location
     */
    public List<Employee> getEmployees() {
        return this.employees;
    }

    /**
     * Mutator for employees
     * @param list of employees who work at location
     */
    public void setEmployees(List<Employee> employees) {
        if(employees == null){
            throw new IllegalArgumentException("List of Employees is null");
        }
        this.employees= employees;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Location)) {
            return false;
        }
        Location l2= (Location) o;

        return this.address == l2.address && 
               this.branch == l2.branch && 
               this.cars == l2.cars && 
               this.employees == l2.employees;
    }
}
