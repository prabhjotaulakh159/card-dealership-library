package com.dealer.data.sorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dealer.data.models.people.Customer;

/**
 * Provides functionalities to sort customers
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class AbstractCustomerSorter extends AbstractSorter implements Comparator<Customer> {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public AbstractCustomerSorter(Order order) {
        super(order);
    }

    /**
     * Sorts a list of customers by various strategies
     * @param customers List of customers to be sorted
     * @return A new list of customers sorted in the desired manner
     */
    public void sortCustomers(List<Customer> customers) {
        Collections.sort(customers, this);
    }
}
