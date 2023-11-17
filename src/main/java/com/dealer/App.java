package com.dealer;

import java.util.List;

import com.dealer.data.loaders.FileLoader;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;
import com.dealer.data.sorters.impl.CarPriceSorter;
import com.dealer.models.cars.Car;

public class App {
    public static void main(String[] args) {
        IDataLoader dataLoader = new FileLoader();
        List<Car> cars = dataLoader.getCars();
        for (Car car : cars) System.out.println(car);
        System.out.println("------------------------------------------------");
        AbstractCarSorter carSorter = new CarPriceSorter(Order.ASCENDING);
        carSorter.sortCars(cars);
        for (Car car : cars) System.out.println(car);
    }
}
