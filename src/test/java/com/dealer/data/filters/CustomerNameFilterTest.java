package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CustomerNameFilter;
import com.dealer.models.people.Customer;

public class CustomerNameFilterTest {
    @Test
    public void filter_is_equal_to_name(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", "5149999999"));
        customers.add(new Customer("Jane", "5149999999"));
        customers.add(new Customer("John", "5149999999"));
        ICustomerFilter filter = new CustomerNameFilter("John");
        List<Customer> filtered = filter.filterCustomers(customers);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_returns_empty(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", "5149999999"));
        customers.add(new Customer("Jane", "5149999999"));
        customers.add(new Customer("John", "5149999999"));
        ICustomerFilter filter = new CustomerNameFilter("Jot");
        List<Customer> filtered = filter.filterCustomers(customers);
        assertEquals(0, filtered.size());
    }
}
