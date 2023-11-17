package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.CarChargerTypeSorter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

/**
 * Test class for CarChargerTypeSorter
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarChargerTypeSorterTest {
    @Test
    public void sorts_ascending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Elctric", 2023, "Blue", 10000, 100, "Type-A"));
        cars.add(new ElectricCar("Elctric", 2023, "Blue", 10000, 100, "Type-B"));
        AbstractCarSorter sorter = new CarChargerTypeSorter(Order.ASCENDING);
        sorter.sortCars(cars);
        ElectricCar ec1 = (ElectricCar) cars.get(0);
        ElectricCar ec2 = (ElectricCar) cars.get(1);
        assertTrue(ec1.getChargerType().compareToIgnoreCase(ec2.getChargerType()) < 0);
    }

    @Test
    public void sorts_descending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Elctric", 2023, "Blue", 10000, 100, "Type-B"));
        cars.add(new ElectricCar("Elctric", 2023, "Blue", 10000, 100, "Type-A"));
        AbstractCarSorter sorter = new CarChargerTypeSorter(Order.DESCENDING);
        sorter.sortCars(cars);
        ElectricCar ec1 = (ElectricCar) cars.get(0);
        ElectricCar ec2 = (ElectricCar) cars.get(1);
        assertTrue(ec1.getChargerType().compareToIgnoreCase(ec2.getChargerType()) > 0);
    }
}
