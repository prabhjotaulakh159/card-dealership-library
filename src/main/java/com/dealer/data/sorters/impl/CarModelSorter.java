package com.dealer.data.sorters.impl;

import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;
import com.dealer.models.cars.Car;

/**
 * Sorts cars by model name
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarModelSorter extends AbstractCarSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CarModelSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Car o1, Car o2) {
        return super.isAscending() ? o1.getModel().compareToIgnoreCase(o2.getModel()) : o2.getModel().compareToIgnoreCase(o1.getModel());
    }
}
