package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.RVNumberOfBedsFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class RVNumberOfBedsFilterTest {
    @Test
    public void filter_equals_num_beds() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 2, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 2, true));
        ICarFilter filter = new RVNumberOfBedsFilter(ListFilter.EQUALS, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(1, recreationalWithKitchens.size());
    }

    @Test
    public void filter_greater_num_beds() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVNumberOfBedsFilter(ListFilter.GREATERTHAN, 1);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(0, recreationalWithKitchens.size());
    }

    @Test
    public void filter_less_num_beds() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 1, true));
        ICarFilter filter = new RVNumberOfBedsFilter(ListFilter.LESSTHAN, 3);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(3, recreationalWithKitchens.size());
    }

    @Test
    public void filter_greater_equals_num_beds() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 4, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 2, true));
        ICarFilter filter = new RVNumberOfBedsFilter(ListFilter.GREATEREQUALS, 2);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(2, recreationalWithKitchens.size());
    }

    @Test
    public void filter_less_equals_max_passengers() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 1, false));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 1, 3, true));
        cars.add(new RecreationalVehicle("Example", 2023, "Example", 2000, 2, 4, true));
        ICarFilter filter = new RVNumberOfBedsFilter(ListFilter.LESSEQUALS, 3);
        List<Car> recreationalWithKitchens = filter.filterCars(cars);
        assertEquals(2, recreationalWithKitchens.size());
    }
}
