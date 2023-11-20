package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

public class ChargerTypeFilter implements ICarFilter {
    private String chargerType;

    public ChargerTypeFilter(String chargerType) {
      this.chargerType = chargerType;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
     List<Car> carsFiltered= new ArrayList<Car>();

     for(Car car: cars){
      if( (car instanceof ElectricCar) && ((ElectricCar) car).getChargerType().startsWith(this.chargerType)){
        carsFiltered.add(car);
      }
     }
      return carsFiltered;
    }

  
}
