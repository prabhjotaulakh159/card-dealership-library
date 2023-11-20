package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICustomerFilter;
import com.dealer.models.people.Customer;

public class CustomerPhoneFilter implements ICustomerFilter {

    @Override
    public List<Customer> filterCustomers(List<Customer> customers, String input){
      List<Customer> customersFiltered= new ArrayList<Customer>();

         for(Customer cus: customers){
          if(cus.getPhone().startsWith(input)){
            customersFiltered.add(cus);
          }
         }

        return customersFiltered;
    }
}
