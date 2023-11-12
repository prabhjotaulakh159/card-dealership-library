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
     * @throws IllegalArgumentException if any value is null
     */
    public Appointment(Employee employee, Customer customer, Location location, Date date){
        if(employee ==  null){
            throw new IllegalArgumentException("employee is null. try again");
        }
        if(customer == null){
            throw new IllegalArgumentException("Customer is null, try again");
        }
        if(location == null){
            throw new IllegalArgumentException("Location is null, try again");
        }
        if(date == null){
            throw new IllegalArgumentException("Date is null, try again");
        }
        if(date.getDate() >31 || date.getDate()<1){
            throw new IllegalArgumentException("Date day is invalid, try again");
        }
        if(date.getMonth()> 11 || date.getMonth() < 0){
            throw new IllegalArgumentException("Date month is invalid, try again");
        }

        this.employee= employee;
        this.customer= customer;
        this.location = location;
        this.date= date;
    }

    /**
     * Accessor for Employee
     * @return Employee for meeting
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Mutator for Employee
     * @param Employee the employee that will be participating this appointment
     * @param IllegalArgumentException if employee is null
     */
    public void setEmployee(Employee employee) {
         if(employee ==  null){
            throw new IllegalArgumentException("employee is null. try again");
        }
        this.employee= employee;
    }

    /**
     * Accessor for Customer
     * @return customer that will do the appointment
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Mutator for Customer
     * @param customer the customer that will be assigned this appointment
     * @param IllegalArgumentException if customer is null
     */
    public void setCustomer(Customer customer) {
         if(customer ==  null){
            throw new IllegalArgumentException("Customer is null. try again");
        }
        this.customer= customer;
    }

    /**
     * Accessor for Location
     * @return Location where appointment takes place
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Mutator for Location
     * @param location the location that will be set for the appointment
     * @param IllegalArgumentException if location is null
     */
    public void setLocation(Location location) {
         if(location ==  null){
            throw new IllegalArgumentException("Location is null. try again");
        }
        this.location= location;
    }

    /**
     * Accessor for Date
     * @return Date of when appointment is made
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Mutator for Date
     * @param date the potential date that will be implemented for appointment
     * @param IllegalArgumentException if date is null
     */
    public void setDate(Date date) {
        if(date == null){
            throw new IllegalArgumentException("Date is null, try again");
        }
        if(date.getDate() >31 || date.getDate()<1){
            throw new IllegalArgumentException("Date day is invalid, try again");
        }
        if(date.getMonth()> 11 || date.getMonth() < 0){
            throw new IllegalArgumentException("Date month is invalid, try again");
        }

        this.date= date;
    }

    @Override
    public boolean equals(Object o){
        Appointment ap=(Appointment) o;

        return this.getEmployee() == ap.getEmployee() && this.getCustomer() == ap.getCustomer() &&
        this.getLocation() == ap.getLocation() && this.getDate() == ap.getDate();
    }
}
