package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class hasKitchenFilter{

    public List<Car> filterCarsHasKitchenTrue(List<Car> cars){
      List<Car> carsFiltered= new ArrayList<Car>();

      for(Car car : cars){
        if( (car instanceof RecreationalVehicle) && ( (RecreationalVehicle)car).isHasKitchen() == true){
          carsFiltered.add(car);
        }
      }
      return carsFiltered;
    }


    public List<Car> filterCarsHasKitchenFalse(List<Car> cars){
      List<Car> carsFiltered= new ArrayList<Car>();

      for(Car car : cars){
        if( (car instanceof RecreationalVehicle) && ( (RecreationalVehicle)car).isHasKitchen() == false){
          carsFiltered.add(car);
        }
      }
      return carsFiltered;
    }


} 
