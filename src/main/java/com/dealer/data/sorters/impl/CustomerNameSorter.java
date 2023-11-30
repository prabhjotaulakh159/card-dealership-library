package com.dealer.data.sorters.impl;

import com.dealer.data.models.people.Customer;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.Order;

/**
 * Sorts customers by name
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CustomerNameSorter extends AbstractCustomerSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CustomerNameSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Customer o1, Customer o2) {
        return this.isAscending() ? o1.getName().compareToIgnoreCase(o2.getName()) : o2.getName().compareToIgnoreCase(o1.getName());
    }
}
