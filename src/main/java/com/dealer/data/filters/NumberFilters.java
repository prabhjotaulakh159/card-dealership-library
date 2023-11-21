package com.dealer.data.filters;

/**
 * All filters that filter by number extend this class
 * to be able to filter number in various ways without having to 
 * implement different methods for >=, <=, etc.
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class NumberFilters {
    private ListFilter filter;

    /**
     * Constructor 
     * @param filter Number filter operation 
     */
    public NumberFilters(ListFilter filter){
        this.filter= filter;
    }

    /**
     * @return Whether or not the operation for filtering is an == operation
     */
    public boolean equalsTo(){
        return this.filter == ListFilter.EQUALS;
    }

    /**
     * @return Whether or not the operation for filtering is a > operation
     */
    public boolean greaterThan(){
        return this.filter == ListFilter.GREATERTHAN;
    }

    /**
     * @return Whether or not the operation for filtering is a < operation
     */
    public boolean lessThan(){
        return this.filter == ListFilter.LESSTHAN;
    }

    /**
     * @return Whether or not the operation for filtering is an >= operation
     */
    public boolean greaterThanEqualsTo(){
        return this.filter == ListFilter.GREATEREQUALS;
    }

    /**
     * @return Whether or not the operation for filtering is a <= operation
     */
    public boolean lessThanEqualsTo(){
        return this.filter == ListFilter.LESSEQUALS;
    }
}
