package com.dealer.models;

import java.util.Date;

import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

/**
 * Implementing Appointments for Customers and Employees
 */
public class Appointment {
    private Employee employee;
    private Customer customer;
    private Location location;
    private Date date;


    /**
     * Appointment Constructor
     * @param employee The Employee meeting the customer for the Appointment
     * @param customer the Customer that schedules it to meet an employee
     * @param Location car dealership they are making the appointment at
     * @param date the Day they appointment is held
     * @param IllegalArgumentException if any value is null
     */
    public Appointment(Employee employee, Customer customer, Location location, Date date){
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Accessor for Employee
     * @return Employee for meeting
     */
    public Employee getEmployee() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for Employee
     * @param Employee the employee that will be participating this appointment
     * @param IllegalArgumentException if employee is null
     */
    public void setEmployee(Employee employee) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Accessor for Customer
     * @return customer that will do the appointment
     */
    public Customer getCustomer() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for Customer
     * @param customer the customer that will be assigned this appointment
     * @param IllegalArgumentException if customer is null
     */
    public void setCustomer(Customer customer) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Accessor for Location
     * @return Location where appointment takes place
     */
    public Location getLocation() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for Location
     * @param location the location that will be set for the appointment
     * @param IllegalArgumentException if location is null
     */
    public void setLocation(Location location) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Accessor for Date
     * @return Date of when appointment is made
     */
    public Date getDate() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Mutator for Date
     * @param date the potential date that will be implemented for appointment
     * @param IllegalArgumentException if date is null
     */
    public void setDate(Date date) {
        throw new UnsupportedOperationException("not implemented");
    }
}
