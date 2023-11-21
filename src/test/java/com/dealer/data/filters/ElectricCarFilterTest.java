package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.TypeElectricCarFilter;
import com.dealer.data.filters.impl.TypeRVFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

public class ElectricCarFilterTest {
    

    @Test
    public void filter_works(){
        List<Car> cars= new ArrayList<Car>();
        cars.add(new ElectricCar("Airstream Basecamp", 2021, "Silver", 30000, 700, "Electric"));
        cars.add(new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 600, "Electric"));
        cars.add(new ElectricCar("Toyota Corolla", 2005, "Red", 6000, 600, "Electric"));
        cars.add(new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 30000, 7, 5, true));
        
        ICarFilter filter = new TypeElectricCarFilter();

        List<Car> electricCars= filter.filterCars(cars);

        assertEquals(3, electricCars.size());
    }
}
