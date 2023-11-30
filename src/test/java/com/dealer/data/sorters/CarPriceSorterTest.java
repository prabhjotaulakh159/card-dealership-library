package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.models.cars.Car;
import com.dealer.data.sorters.impl.CarPriceSorter;

/**
 * Test class for CarPriceSorter
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarPriceSorterTest {
    @Test
    public void sorts_ascending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Tesla Model 3", 2020, "Blue", 45000));
        cars.add(new Car("Airstream Basecamp", 2021, "Silver", 30000));
        cars.add(new Car("Toyota Corolla", 2005, "Red", 8000));
        AbstractCarSorter sorter = new CarPriceSorter(Order.ASCENDING);
        sorter.sortCars(cars);
        assertTrue(cars.get(0).getPrice() < cars.get(1).getPrice() && cars.get(1).getPrice() < cars.get(2).getPrice());
    }

    @Test
    public void sorts_descending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota Corolla", 2005, "Red", 8000));
        cars.add(new Car("Airstream Basecamp", 2021, "Silver", 30000));
        cars.add(new Car("Tesla Model 3", 2020, "Blue", 45000));
        AbstractCarSorter sorter = new CarPriceSorter(Order.DESCENDING);
        sorter.sortCars(cars);
        assertTrue(cars.get(0).getPrice() > cars.get(1).getPrice() && cars.get(1).getPrice() > cars.get(2).getPrice());
    }
}
