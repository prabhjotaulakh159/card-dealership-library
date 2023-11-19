package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class RVMaxPassengersFilter extends NumberFilters implements ICarFilter {
    private int maxPassengers;

    public RVMaxPassengersFilter(ListFilter filters, int maxPassengers) {
      super(filters);
      this.maxPassengers = maxPassengers;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
     List<Car> carsFiltered= new ArrayList<Car>();
    
     if(super.equalsTo()){
      for(Car car: cars){
        if( (car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() == this.maxPassengers){
          carsFiltered.add(car);
        }
      }
     }else if(super.greaterThan()){
      for(Car car: cars){
        if( (car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() > this.maxPassengers){
          carsFiltered.add(car);
        }
      }
     }else if(super.lessThan()){
      for(Car car: cars){
        if( (car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() < this.maxPassengers){
          carsFiltered.add(car);
        }
      }
     } else if(super.greaterThanEqualsTo()){
      for(Car car: cars){
        if( (car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() >= this.maxPassengers){
          carsFiltered.add(car);
        }
      }
     }else if(super.lessThanEqualsTo()){
      for(Car car: cars){
        if( (car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() <= this.maxPassengers){
          carsFiltered.add(car);
        }
      }
     }
      return carsFiltered;
    }    
}
