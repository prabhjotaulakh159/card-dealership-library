package com.dealer.data.sorters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.sorters.impl.CarMaxPassengersSorter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class CarMaxPassengersSorterTest {
    @Test
    public void sorts_ascending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 30000, 10, 5, true));
        cars.add(new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 30000, 7, 5, true));
        AbstractCarSorter sorter = new CarMaxPassengersSorter(Order.ASCENDING);
        sorter.sortCars(cars);
        RecreationalVehicle c1 = (RecreationalVehicle) cars.get(0);
        RecreationalVehicle c2 = (RecreationalVehicle) cars.get(1);
        assertTrue(c1.getMaxPassengers() < c2.getMaxPassengers());
    }

    @Test
    public void sorts_descending() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 30000, 7, 5, true));
        cars.add(new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 30000, 10, 5, true));
        AbstractCarSorter sorter = new CarMaxPassengersSorter(Order.DESCENDING);
        sorter.sortCars(cars);
        RecreationalVehicle c1 = (RecreationalVehicle) cars.get(0);
        RecreationalVehicle c2 = (RecreationalVehicle) cars.get(1);
        assertTrue(c1.getMaxPassengers() > c2.getMaxPassengers());
    }
}
