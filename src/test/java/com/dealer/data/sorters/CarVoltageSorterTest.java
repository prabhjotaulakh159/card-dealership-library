package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.CarVoltageSorter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

public class CarVoltageSorterTest {
    @Test
    public void sorts_ascending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Airstream Basecamp", 2021, "Silver", 30000, 700, "Electric"));
        cars.add(new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 600, "Electric"));
        cars.add(new ElectricCar("Toyota Corolla", 2005, "Red", 6000, 600, "Electric"));
        AbstractCarSorter sorter = new CarVoltageSorter(Order.ASCENDING);
        sorter.sortCars(cars);
        ElectricCar c1 = (ElectricCar) cars.get(0);
        ElectricCar c2 = (ElectricCar) cars.get(1);
        ElectricCar c3 = (ElectricCar) cars.get(2);
        assertTrue(c1.getVoltage() == c2.getVoltage() && c2.getVoltage() < c3.getVoltage());
    }

    @Test
    public void sorts_sescending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Airstream Basecamp", 2021, "Silver", 30000, 850, "Electric"));
        cars.add(new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 50, "Electric"));
        cars.add(new ElectricCar("Toyota Corolla", 2005, "Red", 600, 900, "Electric"));
        AbstractCarSorter sorter = new CarVoltageSorter(Order.DESCENDING);
        sorter.sortCars(cars);
        ElectricCar c1 = (ElectricCar) cars.get(0);
        ElectricCar c2 = (ElectricCar) cars.get(1);
        ElectricCar c3 = (ElectricCar) cars.get(2);
        assertTrue(c1.getVoltage() > c2.getVoltage() && c2.getVoltage() > c3.getVoltage());
    }
}
