package com.dealer.data.sorters.impl;

import com.dealer.data.models.people.Employee;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.Order;

/**
 * Sorts employees by name
 * @author Prabhjot Aulakh, Safin Haque
 */
public class EmployeeNameSorter extends AbstractEmployeeSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public EmployeeNameSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return this.isAscending()? o1.getName().compareToIgnoreCase(o2.getName()) : o2.getName().compareToIgnoreCase(o1.getName());
    }
}
