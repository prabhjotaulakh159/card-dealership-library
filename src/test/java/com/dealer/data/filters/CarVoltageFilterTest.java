package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CarVoltageFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

@SuppressWarnings("unused")
public class CarVoltageFilterTest {
    @Test
    public void constructor() {
        ICarFilter filter = new CarVoltageFilter(ListFilter.EQUALS, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_negative_voltage() {
        ICarFilter filter = new CarVoltageFilter(ListFilter.EQUALS, -1000);
    }

    @Test
    public void filter_equal_voltage() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2000, "USB"));
        ICarFilter filter = new CarVoltageFilter(ListFilter.EQUALS, 1000);
        List<Car> filtered = filter.filterCars(cars);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_greater_voltage() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2000, "USB"));
        ICarFilter filter = new CarVoltageFilter(ListFilter.GREATERTHAN, 1000);
        List<Car> filtered = filter.filterCars(cars);
        assertEquals(1, filtered.size());
    }

    @Test
    public void filter_less_voltage() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2000, "USB"));
        ICarFilter filter = new CarVoltageFilter(ListFilter.LESSTHAN, 2000);
        List<Car> filtered = filter.filterCars(cars);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_greater_equals_voltage() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2200, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2000, "USB"));
        ICarFilter filter = new CarVoltageFilter(ListFilter.GREATEREQUALS, 2000);
        List<Car> filtered = filter.filterCars(cars);
        assertEquals(2, filtered.size());
    }

    @Test
    public void filter_less_equals_voltage() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 1000, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2200, "USB"));
        cars.add(new ElectricCar("Example", 2023, "Example", 2000, 2000, "USB"));
        ICarFilter filter = new CarVoltageFilter(ListFilter.LESSEQUALS, 2000);
        List<Car> filtered = filter.filterCars(cars);
        assertEquals(2, filtered.size());
    }
}
