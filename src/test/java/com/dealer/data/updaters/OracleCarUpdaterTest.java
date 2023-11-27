package com.dealer.data.updaters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

public class OracleCarUpdaterTest {
    @Test
    public void create_car() throws LoaderException {
        OracleLoader loader = new OracleLoader();
        OracleCarUpdater updater = new OracleCarUpdater(loader);
        Car car = new Car("New Model", 2023, "New Color", 10000);
        updater.create(car);
        List<Car> cars = loader.getCars();
        assertEquals(13, cars.size());
        assertTrue(cars.get(12).equals(car));
    }

    @Test
    public void create_electric() throws LoaderException {
        OracleLoader loader = new OracleLoader();
        OracleCarUpdater updater = new OracleCarUpdater(loader);
        ElectricCar car = new ElectricCar("New Model", 2023, "New Color", 10000, 400, "Charger");
        updater.create(car);
        List<Car> cars = loader.getCars();
        assertEquals(13, cars.size());
        assertTrue(cars.get(12).equals(car));
    }

    @Test
    public void create_rv() throws LoaderException {
        OracleLoader loader = new OracleLoader();
        OracleCarUpdater updater = new OracleCarUpdater(loader);
        RecreationalVehicle car = new RecreationalVehicle("New Model", 2023, "New Color", 10000, 1, 1, true);
        updater.create(car);
        List<Car> cars = loader.getCars();
        assertEquals(13, cars.size());
        assertTrue(cars.get(12).equals(car));
    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }
}
