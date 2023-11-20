package com.dealer.data.filters;

import java.util.ArrayList;
import java.util.List;

import com.dealer.models.cars.Car;

public class CarModelFilter implements ICarFilter {
    private String query;

    public CarModelFilter(String query) {
        this.query = query;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
        List<Car> filtered = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().contains(this.query)) {
                filtered.add(car);
            }
        }
        return filtered;
    }
}
