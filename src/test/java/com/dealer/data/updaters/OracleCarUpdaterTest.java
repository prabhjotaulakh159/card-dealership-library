package com.dealer.data.updaters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

public class OracleCarUpdaterTest {
    @Test
    public void create() throws LoaderException {
        OracleLoader loader = new OracleLoader();
        OracleCarUpdater updater = new OracleCarUpdater();
        this.resetDbToOriginalState(updater);
        RecreationalVehicle car = new RecreationalVehicle("New Model", 2023, "New Color", 10000, 1, 1, true);
        updater.create(car);
        List<Car> cars = loader.getCars();
        assertEquals(13, cars.size());
        assertTrue(cars.get(12).equals(car));
        this.resetDbToOriginalState(updater);
    }

    @Test
    public void update() throws LoaderException {
        OracleLoader loader = new OracleLoader();
        OracleCarUpdater updater = new OracleCarUpdater();
        this.resetDbToOriginalState(updater);
        RecreationalVehicle car = new RecreationalVehicle("New Model", 2023, "New Color", 10000, 1, 1, true);
        updater.create(car);
        RecreationalVehicle newCar = new RecreationalVehicle("Even new model", 2024, "Even newer color", 20000, 2, 2, false);
        updater.update(newCar, 13);
        List<Car> cars = loader.getCars();
        assertTrue(cars.size() == 13);
        assertTrue(cars.get(12).equals(newCar));
        this.resetDbToOriginalState(updater);
    }

    @Test
    public void delete() throws LoaderException {
        OracleLoader loader = new OracleLoader();
        OracleCarUpdater updater = new OracleCarUpdater();
        this.resetDbToOriginalState(updater);
        updater.create(new Car("New Model", 2023, "New Color", 10000));
        List<Car> cars = loader.getCars();
        assertEquals(13, cars.size());
        updater.delete(13);
        assertEquals(12, loader.getCars().size());
    }

    public void resetDbToOriginalState(OracleCarUpdater oracleCarUpdater) throws LoaderException {
        try {
            oracleCarUpdater.getConnection().prepareStatement("DELETE FROM programming_cars WHERE id > 12").execute();
            oracleCarUpdater.getConnection().commit();
        } catch (SQLException e) {
            throw new LoaderException(e);
        }
    }
}
