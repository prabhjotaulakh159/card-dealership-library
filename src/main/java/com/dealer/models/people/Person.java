package com.dealer.models.people;

/**
 * A person who has a name and phone
 * @author Prabhjot Aulakh Safin Haque
 */
public abstract class Person {
    private String name;
    private String phone;
    
    /**
     * Constructor 
     * @param name Name of the person
     * @param phone Phone number of the person
     * @throws IllegalArgumentException If either parameter is null
     */
    public Person(String name, String phone) {
        if (name == null) 
            throw new IllegalArgumentException("Name cannot be null");
        if (phone == null) 
            throw new IllegalArgumentException("Phone cannot be null");
        if (name.isEmpty() || name.isBlank()) 
            throw new IllegalArgumentException("Name cannot be empty");
        if (phone.isEmpty() || phone.isBlank()) 
            throw new IllegalArgumentException("Phone cannot be empty");
        this.name = name;
        this.phone = phone;
    }

    /**
     * Accessor for name
     * @return Name of the person
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mutator for name
     * @param name Name of the person
     * @throws IllegalArgumentException If name is empty/null
     */
    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null");
        if (name.isEmpty() || name.isBlank()) 
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    /**
     * Accessor for phone
     * @return Phone number of the person
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Mutator for phone
     * @param phone Phone number of the person
     * @throws IllegalArgumentException If phone number is empty/null
     */
    public void setPhone(String phone) {
        if (phone == null) 
            throw new IllegalArgumentException("Phone cannot be null !");
        if (phone.isEmpty() || phone.isBlank()) 
            throw new IllegalArgumentException("Phone cannot be empty");
        this.phone = phone;
    }

    /**
     * Checks if two people have the same name and phone
     * @param o Object for comparison
     * @return Whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) 
            return false;
        Person person = (Person) o;
        return this.name.equals(person.name) && this.phone.equals(person.phone);
    }

    /**
     * Creates a string representation of a person
     * @return String representation of a person 
     */
    @Override
    public String toString() {
        return this.name + " | " + this.phone;
    }
}
