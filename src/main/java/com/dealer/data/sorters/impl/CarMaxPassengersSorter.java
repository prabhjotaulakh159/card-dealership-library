package com.dealer.data.sorters.impl;

import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Sorts recreational vehicles by max passengers
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarMaxPassengersSorter extends AbstractCarSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CarMaxPassengersSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Car o1, Car o2) {
        RecreationalVehicle r1 = (RecreationalVehicle) o1;
        RecreationalVehicle r2 = (RecreationalVehicle) o2;
        return super.isAscending() ? r1.getMaxPassengers() - r2.getMaxPassengers() : r2.getMaxPassengers() - r1.getMaxPassengers();
    }
}
