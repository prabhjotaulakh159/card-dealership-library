package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.models.cars.Car;

/**
 * Implements ICarFilter to filter cars by their price
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarPriceFilter extends NumberFilters implements ICarFilter {
    private int price;

    /**
     * Constructor
     * @param filter Filter operation
     * @param price Price to filter by
     */
    public CarPriceFilter(ListFilter filter, int price){
        super(filter);
        if(price <= 0){
            throw new IllegalArgumentException("price is megative or zero");
        }
        this.price = price;
    }

    @Override
    public List<Car> filterCars (List<Car> cars){
        List<Car> carsFiltered = new ArrayList<Car>();
        if(super.equalsTo()){
            for(Car car: cars){
                if(car.getPrice() == this.price){
                    carsFiltered.add(car);
                }
            }
        } else if(super.greaterThan()){
            for(Car car: cars){
                if(car.getPrice() > this.price){
                    carsFiltered.add(car);
                }
            }
        } else if(super.lessThan()){
            for(Car car: cars){
                if(car.getPrice() < this.price){
                    carsFiltered.add(car);
                }
            }
        } else if(super.greaterThanEqualsTo()){
            for(Car car: cars){
                if(car.getPrice() >= this.price){
                    carsFiltered.add(car);
                }
            }
        } else if(super.lessThanEqualsTo()){
            for(Car car: cars){
                if(car.getPrice() <= this.price){
                    carsFiltered.add(car);
                }
            }
        }
        return carsFiltered;
    }
}
