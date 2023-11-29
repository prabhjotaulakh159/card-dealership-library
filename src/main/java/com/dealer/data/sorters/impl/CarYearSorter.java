package com.dealer.data.sorters.impl;

import com.dealer.data.models.cars.Car;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;

/**
 * Sorts cars by year
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarYearSorter extends AbstractCarSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CarYearSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Car o1, Car o2) {
        return super.isAscending() ? o1.getYear() - o2.getYear() : o2.getYear() - o1.getYear();
    }
}
