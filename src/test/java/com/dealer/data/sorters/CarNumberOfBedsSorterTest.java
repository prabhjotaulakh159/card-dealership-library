package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.CarNumberOfBedsSorter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Test class for CarNumberOfBedsSorter
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarNumberOfBedsSorterTest {
    @Test
    public void sorts_ascending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("RV", 2002, "Red", 10000, 4, 8, false));
        cars.add(new RecreationalVehicle("RV", 2002, "Red", 10000, 4, 4, false));
        AbstractCarSorter sorter = new CarNumberOfBedsSorter(Order.ASCENDING);
        sorter.sortCars(cars);
        RecreationalVehicle rv1 = (RecreationalVehicle) cars.get(0);
        RecreationalVehicle rv2 = (RecreationalVehicle) cars.get(1);
        assertTrue(rv1.getNumberOfBeds() < rv2.getNumberOfBeds());
    }

    @Test
    public void sorts_descending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("RV", 2002, "Red", 10000, 4, 4, false));
        cars.add(new RecreationalVehicle("RV", 2002, "Red", 10000, 4, 5, false));
        AbstractCarSorter sorter = new CarNumberOfBedsSorter(Order.DESCENDING);
        sorter.sortCars(cars);
        RecreationalVehicle rv1 = (RecreationalVehicle) cars.get(0);
        RecreationalVehicle rv2 = (RecreationalVehicle) cars.get(1);
        assertTrue(rv1.getNumberOfBeds() > rv2.getNumberOfBeds());
    }
}
