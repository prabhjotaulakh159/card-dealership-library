package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;

/**
 * Implements ICarFilter to filter cars by color
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarColorFilter implements ICarFilter {
    private String color;

    /**
     * Constructor
     * @param color Color to filter by
     */
    public CarColorFilter(String color) {
        this.color = color;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
        List<Car> carsFiltered= new ArrayList<Car>();
        for(Car car : cars){
            if(car.getColor().startsWith(this.color)){
                carsFiltered.add(car);
            }
        }
        return carsFiltered;
    }
}
