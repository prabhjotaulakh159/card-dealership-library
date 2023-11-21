package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.RVMaxPassengersFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class RVMaxPassengerFilterTest {
    @Test
    public void filter_equals_max_passengers() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVMaxPassengersFilter(ListFilter.EQUALS, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(2, recreationalWithKitchens.size());
    }

    @Test
    public void filter_greater_max_passengers() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVMaxPassengersFilter(ListFilter.GREATERTHAN, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(1, recreationalWithKitchens.size());
    }

    @Test
    public void filter_less_max_passengers() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVMaxPassengersFilter(ListFilter.LESSTHAN, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(0, recreationalWithKitchens.size());
    }

    @Test
    public void filter_greater_equals_max_passengers() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVMaxPassengersFilter(ListFilter.GREATEREQUALS, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(3, recreationalWithKitchens.size());
    }

    @Test
    public void filter_less_equals_max_passengers() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVMaxPassengersFilter(ListFilter.LESSEQUALS, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(2, recreationalWithKitchens.size());
    }
}
