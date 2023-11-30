package com.dealer.data.loaders;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;

public class OracleLoaderTest {
    @Test
    public void return_list_of_12_cars() throws LoaderException {
        IDataLoader oracleLoader = new OracleLoader();
        try {   
            ((OracleLoader)oracleLoader).getConnection().prepareStatement("DELETE FROM programming_cars WHERE id > 12");
            ((OracleLoader)oracleLoader).getConnection().commit();
        } catch (SQLException e) {
            throw new LoaderException(e);
        }
        List<Car> list = oracleLoader.getCars();
        assertTrue(list.size() == 12);
    }

    @Test
    public void first_car_matches() throws LoaderException {
        Car other = new Car("Toyota Corolla", 2005, "Red", 8000);
        IDataLoader oracleLoader = new OracleLoader();
        List<Car> list = oracleLoader.getCars();
        assertTrue(list.get(0).equals(other));
    }

    @Test
    public void first_electric_car_matches() throws LoaderException {
        ElectricCar other = new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 480, "Supercharger");
        IDataLoader oracleLoader = new OracleLoader();
        List<Car> list = oracleLoader.getCars();
        System.out.println(list.get(0).getModel());
        assertTrue(list.get(6).equals(other));
    }

    @Test
    public void first_rv_matches() throws LoaderException {
        RecreationalVehicle other = new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 40000, 4, 2, false);
        IDataLoader oracleLoader = new OracleLoader();
        List<Car> list = oracleLoader.getCars();
        assertTrue(list.get(10).equals(other));
    }
}
