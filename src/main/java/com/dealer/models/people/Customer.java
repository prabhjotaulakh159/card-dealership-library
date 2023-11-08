package com.dealer.models.people;

/**
 * Customer that can buy cars
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Customer extends Person {
    /**
     * Constructor
     * @param name Name of the customer
     * @param phone Phone number of the customer
     * @throws IllegalArgumentException if name is empty/null or phone number
     * is not valid or null
     */
    public Customer(String name, String phone) {
        super(name, phone);
        throw new UnsupportedOperationException("Not implemented");
    }
}
