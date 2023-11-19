package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;

public class CarModelFilter implements ICarFilter{
    private String model;

    public CarModelFilter(String model) {
      this.model = model;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
      List<Car> carsFiltered= new ArrayList<Car>();

      for(Car car : cars){
        if(car.getModel().contains(this.model)){
          carsFiltered.add(car);
        }
      }
      return carsFiltered;
    }

    
    
}
