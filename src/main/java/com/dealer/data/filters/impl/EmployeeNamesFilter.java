package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.models.people.Employee;

public class EmployeeNamesFilter extends NumberFilters implements IEmployeeFilter {
  private String input;
  public EmployeeNamesFilter(ListFilter filter, String input){
    super(filter);
    this.input= input;
  }

  @Override
  public List<Employee> filterEmployees(List<Employee> employees){
      List<Employee> employeesFiltered= new ArrayList<Employee>();

      for(Employee emp : employees){
        if(emp.getName().contains(this.input)){
          employeesFiltered.add(emp);
        }
      }
      return employeesFiltered;
  }
}
