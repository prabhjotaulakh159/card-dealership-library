package com.dealer.People;

import com.dealer.models.people.Customer;
import com.dealer.models.people.Person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

@SuppressWarnings("unused")
public class CustomerTest {
    @Test
    public void customer_constructor_works(){
        Person customer = new Customer("Jemery", "5142222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_name_null(){
        Person customer = new Customer(null, "5142222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_name_empty(){
        Person customer = new Customer("", "5142222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_name_blank(){
        Person customer = new Customer("   ", "5142222222");
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_phoneNumber_null(){
        Customer customer = new Customer("Jemery", null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_phoneNumber_empty(){
        Person customer = new Customer("Jemery", "");
    }


    @Test(expected = IllegalArgumentException.class)
    public void customer_invalid_phoneNumber_blank(){
        Customer customer = new Customer("Jemery", "  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setters_name_null(){
        Person customer = new Customer("Jemery", "51422222222");
        customer.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setters_name_empty(){
        Person customer = new Customer("Jemery", "51422222222");
        customer.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setters_name_blank(){
        Person customer = new Customer("Jemery", "51422222222");
        customer.setName(" ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setters_phone_null(){
        Person customer = new Customer("Jemery", "51422222222");
        customer.setPhone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setters_phone_empty(){
        Person customer = new Customer("Jemery", "51422222222");
        customer.setPhone("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setters_phone_blank(){
        Person customer = new Customer("Jemery", "51422222222");
        customer.setPhone(" ");
    }

    @Test
    public void customer_isEqual(){
        Customer customer1 = new Customer("Jemery", "5142222222");
        Customer customer2 = new Customer("Jemery", "5142222222");
        assertTrue(customer1.equals(customer2));
    }

    @Test
    public void customer_isNotEqual(){
        Person customer1 = new Customer("Jemery", "5142222222");
        Person customer2 = new Customer("Michelle", "5142222222");
        assertFalse(customer1.equals(customer2));
    }
}
