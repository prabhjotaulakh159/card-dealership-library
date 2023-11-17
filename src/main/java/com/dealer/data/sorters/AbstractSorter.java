package com.dealer.data.sorters;

/**
 * Determines the order of the sorting for any given type of sorter
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class AbstractSorter {
    private Order order;

    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public AbstractSorter(Order order) {
        this.order = order;
    }

    /**
     * Returns whether or not the sorting is ascending or descending
     * @return The sorting order
     */
    public boolean isAscending() {
        return this.order == Order.ASCENDING;
    }
}
