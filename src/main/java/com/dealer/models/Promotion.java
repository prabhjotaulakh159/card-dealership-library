package com.dealer.models;

import java.util.Date;

/**
 * Promotion running on cars
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Promotion {
    private String name;
    private Date start;
    private Date end;
    
    /**
     * Constructor
     * @param name Name of the promotion
     * @param start Promotion start date
     * @param end Promotion end date
     * @throws IllegalArgumentException If any of the fields are null or empty
     */
    public Promotion(String name, Date start, Date end) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Accessor for name
     * @return Name of the promotion
     */
    public String getName() {
        throw new UnsupportedOperationException("Not implemented");    
    }

    /**
     * Mutator for name
     * @param name Name of the promotion
     * @throws IllegalArgumentException If name is null or empty
     */
    public void setName(String name) {
        throw new UnsupportedOperationException("Not implemented");    
    }

    /**
     * Accessor for start
     * @return Promotion start date
     */
    public Date getStart() {
        throw new UnsupportedOperationException("Not implemented");    
    }   

    /**
     * Mutator for start
     * @param start Promotion start date
     * @throws IllegalArgumentException If start is after end or null
     */
    public void setStart(Date start) {
        throw new UnsupportedOperationException("Not implemented");    
    }

    /**
     * Accessor for end
     * @return Promotion end date
     */
    public Date getEnd() {
        throw new UnsupportedOperationException("Not implemented");    
    }

    /**
     * Mutator for end
     * @param end Promotion end date
     * @throws IllegalArgumentException If end is before start or null
     */
    public void setEnd(Date end) {
        throw new UnsupportedOperationException("Not implemented");    
    }
}
