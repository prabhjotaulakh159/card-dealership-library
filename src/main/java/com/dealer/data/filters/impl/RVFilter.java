package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;
import com.dealer.models.cars.Car;
import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.RecreationalVehicle;

public class RVFilter implements ICarFilter {
    
    @Override
    public List<Car> filterCars(List<Car> cars){
        List<Car> carsFiltered= new ArrayList<Car>();

        for(Car car : cars){
            if(car instanceof RecreationalVehicle){
                carsFiltered.add(car);
            }
        }
        return carsFiltered;
    }


}
