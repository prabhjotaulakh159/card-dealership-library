package com.dealer.People;

import com.dealer.models.people.Customer;

import org.junit.Test;

public class CustomerTest {
    @Test
    public void customer_constructor_works(){
        Customer customer= new Customer("Jemery", "514-222-2222");
    }
}
