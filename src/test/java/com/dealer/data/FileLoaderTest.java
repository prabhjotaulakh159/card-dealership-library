package com.dealer.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.dealer.data.loaders.FileLoader;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Test class for FileLoader
 * @author Prabhjot Aulakh, Safin Haque
 */
public class FileLoaderTest {
    @Test
    public void return_list_of_12_cars() throws IOException, SQLException {
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertEquals(12, list.size());
    }

    @Test
    public void first_car_matches() throws IOException, SQLException {
        Car other = new Car("Toyota Corolla", 2005, "Red", 8000);
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertTrue(list.get(0).equals(other));
    }

    @Test
    public void first_electric_car_matches() throws IOException, SQLException {
        ElectricCar other = new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 480, "Supercharger");
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        System.out.println(list.get(0).getModel());
        assertTrue(list.get(6).equals(other));
    }

    @Test
    public void first_rv_matches() throws IOException, SQLException {
        RecreationalVehicle other = new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 40000, 4, 2, false);
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertTrue(list.get(10).equals(other));
    }
}
