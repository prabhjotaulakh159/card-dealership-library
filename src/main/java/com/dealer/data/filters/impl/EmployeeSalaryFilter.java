package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.models.people.Employee;

public class EmployeeSalaryFilter extends NumberFilters implements IEmployeeFilter {
    private int salary;

    public EmployeeSalaryFilter(ListFilter filter, int salary) {
      super(filter);
      this.salary = salary;
    }

    @Override
    public List<Employee> filterEmployees(List<Employee> employees) {
      List<Employee> emp = new ArrayList<Employee>();

      if(super.equalsTo()){
        for(Employee employee : employees){
          if(employee.getSalary() == this.salary){
            emp.add(employee);
          }
        }
      }
      else if(super.greaterThan()){
        for(Employee employee : employees){
          if(employee.getSalary() > this.salary){
            emp.add(employee);
          }
        }
      }else if(super.lessThan()){
        for(Employee employee : employees){
          if(employee.getSalary() < this.salary){
            emp.add(employee);
          }
        }
      }else if(super.greaterThanEqualsTo()){
        for(Employee employee : employees){
          if(employee.getSalary() >= this.salary){
            emp.add(employee);
          }
        }
      }else if(super.lessThanEqualsTo()){
        for(Employee employee : employees){
          if(employee.getSalary() <= this.salary){
            emp.add(employee);
          }
        }
      }

      return emp;
    }

        
}
