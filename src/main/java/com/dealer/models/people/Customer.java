package com.dealer.models.people;

/**
 * Customer entity
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Customer extends Person {
    /**
     * Constructor
     * @param name Name of the customer
     * @param phone Phone number of the customer
     * @throws IllegalArgumentException If either field is empty/null
     */
    public Customer(String name, String phone) {
        super(name, phone);
    }
}
