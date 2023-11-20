package com.dealer.data.filters;

import java.util.List;

import com.dealer.models.people.Employee;

public interface IEmployeeFilter {
    


    List<Employee> filterEmployees(List<Employee> customers);


}
