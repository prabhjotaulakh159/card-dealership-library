package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;

/**
 * Implements ICarFilter to filter cars that are only electric vehicles
 * @author Prabhjot Aulakh, Safin Haque
 */
public class TypeElectricCarFilter implements ICarFilter {
    @Override
    public List<Car> filterCars(List<Car> cars){
        List<Car> carsFiltered= new ArrayList<Car>();
        for (Car car: cars){
            if (car instanceof ElectricCar){
                carsFiltered.add(car);
            }
        }
        return carsFiltered;
    }
}
