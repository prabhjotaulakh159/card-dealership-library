package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICustomerFilter;
import com.dealer.models.people.Customer;

/**
 * Implements ICustomer Filter to filter customers by name
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CustomerNameFilter implements ICustomerFilter {
    private String name;

    /**
     * Constructor
     * @param name Name to filter by
     */
    public CustomerNameFilter(String name) {
        this.name = name;
    }


    @Override
    public List<Customer> filterCustomers(List<Customer> customers){
        List<Customer> customersFiltered= new ArrayList<Customer>();
        for(Customer cus: customers){
            if(cus.getName().startsWith(this.name)){
                customersFiltered.add(cus);
            }
        }
        return customersFiltered;
    }
}
