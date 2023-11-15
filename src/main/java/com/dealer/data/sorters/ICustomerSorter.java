package com.dealer.data.sorters;

import java.util.List;

import com.dealer.models.people.Customer;

/**
 * Provides functionalities to sort customers
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICustomerSorter {
    /**
     * Sorts a list of customers by various strategies
     * @param customers List of customers to be sorted
     * @return A new list of customers sorted in the desired manner
     */
    List<Customer> sortCustomers(List<Customer> customers);
}
