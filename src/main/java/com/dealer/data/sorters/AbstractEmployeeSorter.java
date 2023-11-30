package com.dealer.data.sorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dealer.data.models.people.Employee;

/**
 * Provides functionalities to sort employees
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class AbstractEmployeeSorter extends AbstractSorter implements Comparator<Employee> {
    
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public AbstractEmployeeSorter(Order order) {
        super(order);
    }

    /**
     * Sorts a list of customers by various strategies
     * @param employees List of customers to be sorted
     * @return A new list of customers sorted in the desired manner
     */
    public void sortEmployees(List<Employee> employees) {
        Collections.sort(employees, this);
    }
}
