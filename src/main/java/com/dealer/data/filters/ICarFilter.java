package com.dealer.data.filters;

import java.util.List;

import com.dealer.models.cars.Car;

/**
 * Provides functionalities to filter cars
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICarFilter {
    /**
     * Filters cars in various different strategies
     * @param cars Carsss to be filtered
     * @return List of filtered cars
     */
    List<Car> filterCars(List<Car> cars);    
}