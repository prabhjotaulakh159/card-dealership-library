package com.dealer.data.filters;

import java.util.List;

import com.dealer.data.models.people.Employee;

/**
 * Provides functionalities to filter employees
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface IEmployeeFilter {
    /**
     * Filters employees in various different strategies
     * @param employees List of employees to filter
     * @param query String to filter employees
     * @return List of filtered employees
     */
    List<Employee> filterEmployees(List<Employee> employees);
}
