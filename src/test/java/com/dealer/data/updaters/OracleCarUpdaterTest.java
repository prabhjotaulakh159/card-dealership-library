package com.dealer.data.updaters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeNotNull;

import java.util.List;

import org.junit.Test;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.RecreationalVehicle;

public class OracleCarUpdaterTest {
    @Test
    public void create_update_delete() {
        try {
            OracleLoader loader = new OracleLoader();
            OracleCarUpdater oracle = new OracleCarUpdater();
            assumeNotNull(((OracleLoader)loader).getConnection());
            RecreationalVehicle created = new RecreationalVehicle("Honda RV Rover", 2023, "Brown", 10000, 1, 1, true);
            oracle.create(created);
            List<Car> carsAfterCreation = loader.getCars();
            assertEquals(13, carsAfterCreation.size());
            assertEquals(created, carsAfterCreation.get(carsAfterCreation.size() - 1));

            RecreationalVehicle updated = new RecreationalVehicle("Honda RV Rover Deluxe", 2023, "Brown", 10000, 1, 1, true);
            oracle.update(updated, carsAfterCreation.size());
            List<Car> carsAfterUpdate = loader.getCars();
            assertEquals(13, carsAfterUpdate.size());
            assertEquals(updated, carsAfterUpdate.get(carsAfterUpdate.size() - 1));

            oracle.delete(carsAfterCreation.size());
            List<Car> carsAfterDeletion = loader.getCars();
            assertEquals(12, carsAfterDeletion.size());
        } catch (LoaderException e) {
            e.printStackTrace();
        }
    }
}
