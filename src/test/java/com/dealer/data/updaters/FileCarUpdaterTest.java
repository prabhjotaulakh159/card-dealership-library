package com.dealer.data.updaters;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.dealer.data.Mode;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.RecreationalVehicle;

public class FileCarUpdaterTest {
    @Test
    public void create_update_delete() {
        try {
            FileLoader loader =  new FileLoader();
            ICarUpdater file = new FileCarUpdater(loader);
            
            RecreationalVehicle created = new RecreationalVehicle("Honda RV Rover", 2023, "Brown", 10000, 1, 1, true);
            file.create(created, Mode.TESTING);
            List<Car> carsAfterCreation = loader.getCars(Mode.TESTING);
            assertEquals(13, carsAfterCreation.size());
            assertEquals(created, carsAfterCreation.get(carsAfterCreation.size() - 1));
            
            RecreationalVehicle updated = new RecreationalVehicle("Honda RV Rover Deluxe", 2023, "Brown", 10000, 1, 1, true);
            file.update(updated, carsAfterCreation.size() - 1, Mode.TESTING);
            List<Car> carsAfterUpdate = loader.getCars(Mode.TESTING);
            assertEquals(13, carsAfterUpdate.size());
            assertEquals(updated, carsAfterUpdate.get(carsAfterUpdate.size() - 1));

            file.delete(carsAfterCreation.size() - 1, Mode.TESTING);
            List<Car> carsAfterDeletion = loader.getCars(Mode.TESTING);
            assertEquals(12, carsAfterDeletion.size());
        } catch (LoaderException e) {
            e.printStackTrace();
        }
    }
}
