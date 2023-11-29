package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.models.people.Customer;

/**
 * Implements ICustomerFilter to filter customers by phone number
 */
public class CustomerPhoneFilter implements ICustomerFilter {
    private String phone;

    /**
     * Constructor 
     * @param phone Phone number to filter by
     */
    public CustomerPhoneFilter(String phone) {
        this.phone = phone;
    }

    @Override
    public List<Customer> filterCustomers(List<Customer> customers){
        List<Customer> customersFiltered = new ArrayList<Customer>();
        for(Customer cus: customers){
            if(cus.getPhone().startsWith(this.phone)){
                customersFiltered.add(cus);
            }
        }
        return customersFiltered;
    }
}
