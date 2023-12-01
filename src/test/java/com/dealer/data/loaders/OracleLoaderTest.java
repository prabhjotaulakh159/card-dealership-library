package com.dealer.data.loaders;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNotNull;

import java.util.List;

import org.junit.Test;

import com.dealer.data.Mode;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;

public class OracleLoaderTest {
    @Test
    public void return_list_of_atleast_12_cars() throws LoaderException {
        IDataLoader oracleLoader = new OracleLoader();
        assumeNotNull(((OracleLoader)oracleLoader).getConnection());
        List<Car> list = oracleLoader.getCars(Mode.TESTING);
        assertTrue(list.size() >= 12);
    }

    @Test
    public void first_car_matches() throws LoaderException {
        IDataLoader oracleLoader = new OracleLoader();
        assumeNotNull(((OracleLoader)oracleLoader).getConnection());
        Car other = new Car("Toyota Corolla", 2005, "Red", 8000);
        List<Car> list = oracleLoader.getCars(Mode.TESTING);
        assertTrue(list.get(0).equals(other));
    }

    @Test
    public void first_electric_car_matches() throws LoaderException {
        IDataLoader oracleLoader = new OracleLoader();
        assumeNotNull(((OracleLoader)oracleLoader).getConnection());
        ElectricCar other = new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 480, "Supercharger");
        List<Car> list = oracleLoader.getCars(Mode.TESTING);
        System.out.println(list.get(0).getModel());
        assertTrue(list.get(6).equals(other));
    }

    @Test
    public void first_rv_matches() throws LoaderException {
        IDataLoader oracleLoader = new OracleLoader();
        assumeNotNull(((OracleLoader)oracleLoader).getConnection());
        RecreationalVehicle other = new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 40000, 4, 2, false);
        List<Car> list = oracleLoader.getCars(Mode.TESTING);
        assertTrue(list.get(10).equals(other));
    }
}
