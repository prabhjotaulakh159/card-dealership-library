package com.dealer.updaters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.Constants;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.updaters.FileCarUpdater;
import com.dealer.data.updaters.ICarUpdater;
import com.dealer.models.cars.Car;

public class FileCarUpdaterTest {
    @Test
    public void create() throws LoaderException {
        FileLoader loader = new FileLoader();
        ICarUpdater updater = new FileCarUpdater(loader);
        Car c = new Car("New Model", 2023, "New Color", 10000);
        updater.create(c);
        assertEquals(13, loader.getCars().size());
        assertTrue(loader.getCars().get(12).equals(c));
        try {
            this.resetFileToOriginalState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() throws LoaderException {
        FileLoader loader = new FileLoader();
        ICarUpdater updater = new FileCarUpdater(loader);
        Car c = new Car("New Model", 2023, "New Color", 10000);
        updater.update(c, 0);
        assertTrue(loader.getCars().get(0).equals(c));
        try {
            this.resetFileToOriginalState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() throws LoaderException {
        FileLoader loader = new FileLoader();
        ICarUpdater updater = new FileCarUpdater(loader);
        updater.delete(11);
        assertEquals(11, loader.getCars().size());
        try {
            this.resetFileToOriginalState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetFileToOriginalState() throws IOException {
        List<String> cars = new ArrayList<String>();
        cars.add("Car,Toyota Corolla,2005,Red,8000");
        cars.add("Car,Honda CR-V,2015,Black,15000");
        cars.add("Car,Ford Mustang,2005,White,12000");
        cars.add("Car,Honda Civic,2002,Orange,2000");
        cars.add("Car,Dodge Journey,2016,Green,4000");
        cars.add("Car,Volkswagen,2018,Yellow,23000");
        cars.add("Electric,Tesla Model 3,2020,Blue,45000,480,Supercharger");
        cars.add("Electric,BMW i3,2018,Silver,25000,360,Wall Connector");
        cars.add("Electric,Range Rover,2023,Black,80000,4000,Wall Supercharger");
        cars.add("Electric,Nissan Leaf,2021,White,100000,400,Nissan I6 Charger");
        cars.add("Recreational,Airstream Basecamp,2021,Silver,40000,4,2,false");
        cars.add("Recreational,Krystal Ship,2006,Beige,8000,2,1,true");
        Path path = Paths.get(Constants.CARS_CSV);
        String data = String.join("\n", cars);
        Files.write(path, data.getBytes(Charset.forName("UTF-8")));
    }

}
