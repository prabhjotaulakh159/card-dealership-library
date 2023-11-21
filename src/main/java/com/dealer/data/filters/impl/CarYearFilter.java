package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.models.cars.Car;

/**
 * Implements ICarFilter to filter cars by year
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarYearFilter extends NumberFilters implements ICarFilter{
    private int year;

    /**
     * Constructor 
     * @param filter Filtering operation
     * @param year year to filter by
     */
    public CarYearFilter(ListFilter filter, int year){
        super(filter);
        if (year < 1998) {
            throw new IllegalArgumentException("Year is before 1998");
        }
        this.year = year;
    }

    @Override
    public List<Car> filterCars(List<Car> cars){
        List<Car> carsFiltered= new ArrayList<Car>();
        if(super.equalsTo()){
            for(Car car: cars){
                if(car.getYear() == this.year){
                    carsFiltered.add(car);
                }
            }
        } else if(super.greaterThan()){
            for(Car car: cars){
                if(car.getYear() > this.year){
                    carsFiltered.add(car);
                }
            }
        } else if(super.lessThan()){
            for(Car car: cars){
                if(car.getYear() < this.year){
                    carsFiltered.add(car);
                }
            }
        } else if(super.greaterThanEqualsTo()){
            for(Car car: cars){
                if(car.getYear() >= this.year){
                    carsFiltered.add(car);
                }
            }
        } else if(super.lessThanEqualsTo()){
            for(Car car: cars){
                if(car.getYear() <= this.year){
                    carsFiltered.add(car);
                }
            }
        }
        return carsFiltered;
    }
}
