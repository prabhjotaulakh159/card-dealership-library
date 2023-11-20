package com.dealer;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.CarModelFilter;
import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;

public class App {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("uhvhqi", 2002, "iqfvb q", 50000));
        cars.add(new Car("uhvhqi", 2002, "iqfvb q", 2000));
        cars.add(new Car("Tesla", 2002, "iqfvb q", 2000));
        ICarFilter filter = new CarModelFilter("Tesla");
        List<Car> filtered = filter.filterCars(cars);
        System.out.println(filtered.size());
    }
}
