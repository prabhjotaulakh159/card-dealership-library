package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.models.people.Employee;

public class EmployeePhoneFilter implements IEmployeeFilter  {
    private String input;

    public EmployeePhoneFilter(String input){
      this.input = input;
    }

    @Override
  public List<Employee> filterEmployees(List<Employee> employees){
       List<Employee> employeesFiltered= new ArrayList<Employee>();

      for(Employee emp : employees){
        if(emp.getPhone().contains(this.input)){
          employeesFiltered.add(emp);
        }
      }
      return employeesFiltered;
  } 
}
