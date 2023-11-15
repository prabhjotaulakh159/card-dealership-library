package com.dealer.data.filters;

import java.util.List;

import com.dealer.models.people.Customer;

/**
 * Provides functionalities to filter customers
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICustomerFilter {
    List<Customer> filterCustomers(List<Customer> customers);
}
