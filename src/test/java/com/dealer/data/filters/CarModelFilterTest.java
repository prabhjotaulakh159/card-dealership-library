package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CarModelFilter;
import com.dealer.data.models.cars.Car;

public class CarModelFilterTest {
    @Test
    public void car_model_filter_works(){
        List<Car> cars = new ArrayList<Car>();
        ICarFilter filter = new CarModelFilter("Toyota");
        cars.add(new Car("Toyota", 2005, "red", 20000));
        cars.add(new Car("Mazda", 2007, "orange", 35000));
        cars.add(new Car("Mitsubishi", 2000, "orange", 20000));
        List<Car> toyotas= filter.filterCars(cars);
        assertEquals(1, toyotas.size());
    }
}
