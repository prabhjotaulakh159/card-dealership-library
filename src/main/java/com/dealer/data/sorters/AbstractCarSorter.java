package com.dealer.data.sorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dealer.data.models.cars.Car;

/**
 * Provides functionalities to sort cars
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class AbstractCarSorter extends AbstractSorter implements Comparator<Car> {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public AbstractCarSorter(Order order) {
        super(order);
    }

    /**
     * Sorts a list of cars by various strategies
     * @param cars List of cars to be sorted
     * @return A new list of cars sorted in the desired manner
     */
    public void sortCars(List<Car> cars) {
        Collections.sort(cars, this);
    }
}
