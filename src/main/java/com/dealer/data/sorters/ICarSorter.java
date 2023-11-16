package com.dealer.data.sorters;

import java.util.List;

import com.dealer.models.cars.Car;

/**
 * Provides functionalities to sort cars
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICarSorter {
    /**
     * Sorts a list of cars by various strategies
     * @param cars List of cars to be sorted
     * @return A new list of cars sorted in the desired manner
     */
    List<Car> sortCars(List<Car> cars);
}
