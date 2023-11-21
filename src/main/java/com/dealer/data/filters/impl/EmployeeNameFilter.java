package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.models.people.Employee;

/**
 * Implements IEmployeeFilter to filter employees by name
 */
public class EmployeeNameFilter implements IEmployeeFilter {
    private String name;
    
    /**
     * Constructor 
     * @param name Name to filter by
     */
    public EmployeeNameFilter(String name){
        this.name = name;
    }

    @Override
    public List<Employee> filterEmployees(List<Employee> employees){
        List<Employee> employeesFiltered= new ArrayList<Employee>();
        for(Employee emp : employees){
            if(emp.getName().startsWith(this.name)){
                employeesFiltered.add(emp);
            }
        }
        return employeesFiltered;
    }
}
