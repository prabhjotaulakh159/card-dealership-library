package com.dealer.data.filters;

import java.util.ArrayList;
import java.util.List;

import com.dealer.models.cars.Car;

public class CarPriceFilter implements ICarFilter {
    private NumberFilter filter;
    private int price;

    public CarPriceFilter(NumberFilter filter, int price) {
        this.filter = filter;
        this.price = price;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
        List<Car> filtered = new ArrayList<Car>();
        if (this.filter == NumberFilter.EQUALS) {
            for (Car car : cars) {
                if (car.getPrice() == this.price) {
                    filtered.add(car);
                }
            }
        } else if (this.filter == NumberFilter.GREATER) {
            for (Car car : cars) {
                if (car.getPrice() > this.price) {
                    filtered.add(car);
                }
            }
        } else if (this.filter == NumberFilter.LESS) {
            for (Car car : cars) {
                if (car.getPrice() < this.price) {
                    filtered.add(car);
                }
            }
        }
        return filtered;
    }   
}
