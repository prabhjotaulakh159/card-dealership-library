package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Implements ICarFilter to filter a list of cars for only regular cars
 * @author Prabhjot Aulakh, Safin Haque
 */
public class TypeRegularCarFilter implements ICarFilter {
    @Override
    public List<Car> filterCars(List<Car> cars){
        List<Car> carsFiltered= new ArrayList<Car>();
        for(Car car : cars){
            if (!(car instanceof ElectricCar) && !(car instanceof RecreationalVehicle)){
                carsFiltered.add(car);
            }
        }
        return carsFiltered;
    }
}
