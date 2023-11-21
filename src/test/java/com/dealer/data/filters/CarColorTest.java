package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CarColorFilter;
import com.dealer.models.cars.Car;

public class CarColorTest {
    @Test
    public void car_model_filter_works(){
        List<Car> cars = new ArrayList<Car>();
        ICarFilter filter = new CarColorFilter("o");
        cars.add(new Car("Toyota", 2005, "red", 20000));
        cars.add(new Car("Mazda", 2007, "orange", 35000));
        cars.add(new Car("Mitsubishi", 2000, "orange", 20000));
        List<Car> orangeCars= filter.filterCars(cars);
        assertEquals(2, orangeCars.size());
    }
}
