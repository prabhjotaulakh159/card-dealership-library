package com.dealer.data.sorters.impl;

import com.dealer.data.models.people.Employee;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.Order;

/**
 * Sorts employees by name
 * @author Prabhjot Aulakh, Safin Haque
 */
public class EmployeeSalarySorter extends AbstractEmployeeSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public EmployeeSalarySorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return this.isAscending()? o1.getSalary() - o2.getSalary() : o2.getSalary() - o1.getSalary();
    }   
}
