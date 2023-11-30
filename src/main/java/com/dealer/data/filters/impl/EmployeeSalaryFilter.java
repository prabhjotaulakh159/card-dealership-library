package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.data.models.people.Employee;

/**
 * Implements IEmployeeFilter to filter employees by their salaries
 * @author Prabhjot Aulakh, Safin Haque
 */
public class EmployeeSalaryFilter extends NumberFilters implements IEmployeeFilter {
    private int salary;

    /**
     * Constructor
     * @param filter How we want to filter salaries
     * @param salary The amount to filter by
     */
    public EmployeeSalaryFilter(ListFilter filter, int salary) {
        super(filter);
        this.salary = salary;
    }

    @Override
    public List<Employee> filterEmployees(List<Employee> employees) {
        List<Employee> filtered = new ArrayList<Employee>();
        if (super.equalsTo()) {
            for (Employee employee : employees) {
                if (employee.getSalary() == this.salary) {
                    filtered.add(employee);
                }
            }
        } else if(super.greaterThan()){
            for(Employee employee : employees){
                if(employee.getSalary() > this.salary){
                    filtered.add(employee);
                }
            }
        } else if(super.lessThan()){
            for(Employee employee : employees){
                if(employee.getSalary() < this.salary){
                    filtered.add(employee);
                }
            }
        } else if(super.greaterThanEqualsTo()){
            for(Employee employee : employees){
                if(employee.getSalary() >= this.salary){
                    filtered.add(employee);
                }
            }
        } else if(super.lessThanEqualsTo()){
            for(Employee employee : employees){
                if(employee.getSalary() <= this.salary){
                    filtered.add(employee);
                }
            }
        }
        return filtered;
    }        
}