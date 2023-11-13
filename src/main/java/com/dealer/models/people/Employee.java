package com.dealer.models.people;

/**
 * Employee that can work at a location and make appointments
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Employee extends Person {
    private int salary;
    
    /**
     * Constructor
     * @param name Name of the employee
     * @param salary Salary of the employee
     * @throws IllegalArgumentException If name is empty/null or location is 
     * null or salary is negative 
     */
    public Employee(String name, String phone, int salary) {
        super(name, phone); 
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be null");
        }
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
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be null");
        }
        this.salary = salary;    
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee p = (Employee) o;
        return super.equals(o) && this.salary == p.salary;
    }

    @Override
    public String toString() {
        return "Employee [salary=" + salary + "]" + super.toString();
    }
}
