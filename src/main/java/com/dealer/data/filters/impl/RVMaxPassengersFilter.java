package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.RecreationalVehicle;

/**
 * Implements ICarFilter to filter RV's by the number of max passengers
 * @author Prabhjot Aulakh, Safin Haque
 */
public class RVMaxPassengersFilter extends NumberFilters implements ICarFilter {
    private int maxPassengers;

    /**
     * Constructor
     * @param filter How we wanna the number of max passengers
     * @param maxPassengers Number to filter by 
     */
    public RVMaxPassengersFilter(ListFilter filter, int maxPassengers) {
        super(filter);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
        List<Car> carsFiltered= new ArrayList<Car>();
        if(super.equalsTo()) {
            for (Car car: cars) {
                if ((car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() == this.maxPassengers){
                    carsFiltered.add(car);
                }
            }
        } else if (super.greaterThan()) {
            for (Car car: cars) {
                if ((car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() > this.maxPassengers){
                    carsFiltered.add(car);
                }
            }
        } else if (super.lessThan()) {
            for (Car car: cars) {
                if ((car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() < this.maxPassengers){
                    carsFiltered.add(car);
                }
            }
        } else if (super.greaterThanEqualsTo()) {
            for (Car car: cars) {
                if ((car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() >= this.maxPassengers){
                    carsFiltered.add(car);
                }
            }
        } else if (super.lessThanEqualsTo()) {
            for (Car car: cars) {
                if ((car instanceof RecreationalVehicle) && ((RecreationalVehicle) car).getMaxPassengers() <= this.maxPassengers){
                    carsFiltered.add(car);
                }
            }
        }
        return carsFiltered;
    }    
}
