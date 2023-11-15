package com.dealer.People;

import com.dealer.models.people.Customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {
    @Test
    public void customer_constructor_works(){
        Customer customer= new Customer("Jemery", "514-222-2222");
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_name_null(){
        Customer customer= new Customer(null, "514-222-2222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_name_empty(){
        Customer customer= new Customer("", "514-222-2222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_name_blank(){
        Customer customer= new Customer("   ", "514-222-2222");
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_phoneNumber_null(){
        Customer customer= new Customer("Jemery", null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_phoneNumber_empty(){
        Customer customer= new Customer("Jemery", "");
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_phoneNumber_blank(){
        Customer customer= new Customer("Jemery", "  ");
    }

    @Test
    public void customer_isEqual(){
        Customer customer1= new Customer("Jemery", "514-222-2222");

        Customer customer2= new Customer("Jemery", "514-222-2222");

        assertTrue(customer1.equals(customer2));
    }

    @Test
    public void customer_isNotEqual(){
        Customer customer1= new Customer("Jemery", "514-222-2222");

        Customer customer2= new Customer("Michelle", "514-222-2222");

        assertFalse(customer1.equals(customer2));
    }
    
    

}
