package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.CarYearSorter;
import com.dealer.models.cars.Car;

/**
 * Test class for CarYearSorter
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarYearSorterTest {
    @Test
    public void sorts_ascending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Airstream Basecamp", 2021, "Silver", 30000));
        cars.add(new Car("Tesla Model 3", 2020, "Blue", 45000));
        cars.add(new Car("Toyota Corolla", 2005, "Red", 8000));
        AbstractCarSorter sorter = new CarYearSorter(Order.ASCENDING);
        sorter.sortCars(cars);
        assertTrue(cars.get(0).getYear() < cars.get(1).getYear() && cars.get(1).getYear() < cars.get(2).getYear());
    }

    @Test
    public void sorts_sescending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota Corolla", 2005, "Red", 8000));
        cars.add(new Car("Tesla Model 3", 2020, "Blue", 45000));
        cars.add(new Car("Airstream Basecamp", 2021, "Silver", 30000));
        AbstractCarSorter sorter = new CarYearSorter(Order.DESCENDING);
        sorter.sortCars(cars);
        assertTrue(cars.get(0).getYear() > cars.get(1).getYear() && cars.get(1).getYear() > cars.get(2).getYear());
    }
}
