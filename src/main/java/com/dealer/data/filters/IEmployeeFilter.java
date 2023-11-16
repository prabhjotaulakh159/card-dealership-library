package com.dealer.data.filters;

import java.util.List;

import com.dealer.models.people.Employee;

/**
 * Provides functionalities to filter employees
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface IEmployeeFilter {
    /**
     * Filters employees in various different strategies
     * @param employees Employees to be filtered
     * @return List of filtered employees
     */
    List<Employee> filterEmployees(List<Employee> employees);
}
