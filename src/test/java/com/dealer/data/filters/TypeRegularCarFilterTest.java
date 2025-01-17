package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.TypeRegularCarFilter;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;

public class TypeRegularCarFilterTest {
    @Test
    public void filter_works(){
        List<Car> cars= new ArrayList<Car>();
        cars.add(new ElectricCar("Airstream Basecamp", 2021, "Silver", 30000, 700, "Electric"));
        cars.add(new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 600, "Electric"));
        cars.add(new ElectricCar("Toyota Corolla", 2005, "Red", 6000, 600, "Electric"));
        cars.add(new Car("Airstream Basecamp", 2021, "Silver", 30000));
        ICarFilter filter = new TypeRegularCarFilter();
        List<Car> carsFiltered= filter.filterCars(cars);
        assertEquals(1, carsFiltered.size());
    }
}
