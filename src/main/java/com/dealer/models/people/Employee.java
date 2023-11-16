package com.dealer.models.people;

/**
 * Employee Entity
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Employee extends Person {
    private int salary;
    
    /**
     * Constructor
     * @param name Name of the employee
     * @param phone Phone number of the employee
     * @param salary Salary of the employee
     * @throws IllegalArgumentException If salary is negative
     */
    public Employee(String name, String phone, int salary) {
        super(name, phone); 
        if (salary < 0) 
            throw new IllegalArgumentException("Salary cannot be negative");
        this.salary = salary;
    }
    
    /**
     * Accessor for salary
     * @return Salary of the employee
     */
    public int getSalary() {
        return this.salary;
    }
    
    /**
     * Mutator for salary
     * @param salary Salary of the employee
     * @throws IllegalArgumentException If salary is negative
     */
    public void setSalary(int salary) {
        if (salary < 0) 
            throw new IllegalArgumentException("Salary cannot be null");
        this.salary = salary;    
    }

    /**
     * Checks if two employees have equal names, phone and salaries
     * @return Whether or not they have the same fields
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) 
            return false;
        Employee employee = (Employee) o;
        return super.equals(employee) && this.salary == employee.salary;
    }

    /**
     * Constructs a string representation of an employee
     * @return String representation of an employee
     */
    @Override
    public String toString() {
        return super.toString() + " | " + this.salary;
    }
}
