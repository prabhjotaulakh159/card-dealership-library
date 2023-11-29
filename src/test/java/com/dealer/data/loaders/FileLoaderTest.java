package com.dealer.data.loaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Test class for FileLoader
 * @author Prabhjot Aulakh, Safin Haque
 */
public class FileLoaderTest {
    @Test
    public void return_list_of_12_cars() throws LoaderException {
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertEquals(12, list.size());
    }

    @Test
    public void first_car_matches() throws LoaderException {
        Car other = new Car("Toyota Corolla", 2005, "Red", 8000);
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertTrue(list.get(0).equals(other));
    }

    @Test
    public void first_electric_car_matches() throws LoaderException {
        ElectricCar other = new ElectricCar("Tesla Model 3", 2020, "Blue", 45000, 480, "Supercharger");
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertTrue(list.get(6).equals(other));
    }

    @Test
    public void first_rv_matches() throws LoaderException {
        RecreationalVehicle other = new RecreationalVehicle("Airstream Basecamp", 2021, "Silver", 40000, 4, 2, false);
        FileLoader fileLoader = new FileLoader();
        List<Car> list = fileLoader.getCars();
        assertTrue(list.get(10).equals(other));
    }
}
