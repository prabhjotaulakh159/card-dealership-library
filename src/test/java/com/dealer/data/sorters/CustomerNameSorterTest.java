package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.CustomerNameSorter;
import com.dealer.models.people.Customer;

public class CustomerNameSorterTest {
    @Test
    public void sorts_ascending() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("Bob", "9999999999"));
        customers.add(new Customer("Adam", "9999999999"));
        AbstractCustomerSorter sorter = new CustomerNameSorter(Order.ASCENDING);
        sorter.sortCustomers(customers);
        assertTrue(customers.get(0).getName().equals("Adam"));
    }

    @Test
    public void sorts_descending() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("Adam", "9999999999"));
        customers.add(new Customer("Bob", "9999999999"));
        AbstractCustomerSorter sorter = new CustomerNameSorter(Order.DESCENDING);
        sorter.sortCustomers(customers);
        assertTrue(customers.get(0).getName().equals("Bob"));
    }
}
