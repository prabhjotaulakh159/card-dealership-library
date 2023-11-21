package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CustomerPhoneFilter;
import com.dealer.models.people.Customer;

public class CustomerPhoneFilterTest {
     @Test
    public void filter_is_equal_to_phone(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", "5141112222"));
        customers.add(new Customer("Jane", "5142223333"));
        customers.add(new Customer("John", "5143334444"));
        ICustomerFilter filter = new CustomerPhoneFilter("5141112222");
        List<Customer> filtered = filter.filterCustomers(customers);
        assertEquals(1, filtered.size());
    }

    @Test
    public void filter_returns_all(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", "5149999999"));
        customers.add(new Customer("Jane", "5149999999"));
        customers.add(new Customer("John", "5149999999"));
        ICustomerFilter filter = new CustomerPhoneFilter("514");
        List<Customer> filtered = filter.filterCustomers(customers);
        assertEquals(3, filtered.size());
    }
}
