package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;

/**
 * Implements ICarFilter to filter electric cars by Charger types
 */
public class ChargerTypeFilter implements ICarFilter {
    private String chargerType;

    /**
     * Constructor
     * @param chargerType Type of charger to filter by
     */
    public ChargerTypeFilter(String chargerType) {
        this.chargerType = chargerType;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
        List<Car> carsFiltered= new ArrayList<Car>();
        for(Car car: cars){
            if((car instanceof ElectricCar) && ((ElectricCar) car).getChargerType().startsWith(this.chargerType)){
                carsFiltered.add(car);
            }
        }
        return carsFiltered;
    }
}
