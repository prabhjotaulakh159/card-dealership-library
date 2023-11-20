package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.ChargerTypeFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

public class ChargerTypeFilterTest {
    

    @Test
    public void car_model_filter_works(){
        List<Car> cars = new ArrayList<Car>();
        ICarFilter filter = new ChargerTypeFilter("Elec");
        cars.add(new ElectricCar("Airstream Basecamp", 2021, "Silver", 30000, 700, "USB-C"));
        cars.add(new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 600, "Electric"));
        cars.add(new ElectricCar("Toyota Corolla", 2005, "Red", 6000, 600, "Electric"));

        List<Car> orangeCars= filter.filterCars(cars);

        assertEquals(2, orangeCars.size());
    }
}
