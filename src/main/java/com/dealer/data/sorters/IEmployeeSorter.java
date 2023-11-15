package com.dealer.data.sorters;

import java.util.List;

import com.dealer.models.people.Employee;

/**
 * Provides functionalities to sort employees
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface IEmployeeSorter {
    /**
     * Sorts a list of customers by various strategies
     * @param employees List of customers to be sorted
     * @return A new list of customers sorted in the desired manner
     */
    List<Employee> sortEmployees(List<Employee> employees);
}
