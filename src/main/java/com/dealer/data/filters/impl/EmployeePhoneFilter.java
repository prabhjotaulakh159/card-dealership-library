package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.models.people.Employee;

/**
 * Implemennts IEmployeeFilter to filter employees by phone number
 * @author Prabhjot Aulakh, Safin Haque
 */
public class EmployeePhoneFilter implements IEmployeeFilter  {
    private String phone;

    /**
     * Constructor 
     * @param phone Phone to filter by
     */
    public EmployeePhoneFilter(String phone){
        this.phone = phone;
    }

    @Override
    public List<Employee> filterEmployees(List<Employee> employees){
        List<Employee> employeesFiltered= new ArrayList<Employee>();
        for(Employee emp : employees){
            if(emp.getPhone().startsWith(this.phone)){
                employeesFiltered.add(emp);
            }
        }
        return employeesFiltered;
    }  
}
