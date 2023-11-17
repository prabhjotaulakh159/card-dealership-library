package com.dealer.data.sorters.impl;

import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;
import com.dealer.models.cars.Car;

/**
 * Sorts cars by price
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarPriceSorter extends AbstractCarSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CarPriceSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Car o1, Car o2) {
        return super.isAscending() ? o1.getPrice() - o2.getPrice() : o2.getPrice() - o1.getPrice();
    }
}
