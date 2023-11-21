package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.RVKitchenFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class RVKitchenFilterTest {
    @Test
    public void filter_returns_2_rv_with_kitchen() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        ICarFilter filter = new RVKitchenFilter(true);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(2, recreationalWithKitchens.size());
    }

    @Test
    public void filter_returns_1_rv_without_kitchen() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        ICarFilter filter = new RVKitchenFilter(false);
        List<Car> recreationalWithoutKitchens = filter.filterCars(cars);
        assertEquals(1, recreationalWithoutKitchens.size());
    }
}
