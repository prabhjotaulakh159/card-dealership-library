package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

public class ElectricCarFilter implements ICarFilter {
    
    @Override
    public List<Car> filterCars(List<Car> cars){
        List<Car> carsFiltered= new ArrayList<Car>();

        for(Car car: cars){
            if(car instanceof ElectricCar){
                carsFiltered.add(car);
            }
        }
        return carsFiltered;
    }
}
