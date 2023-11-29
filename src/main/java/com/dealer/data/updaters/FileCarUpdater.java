package com.dealer.data.updaters;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.dealer.data.Constants;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;

/**
 * Implements ICarUpdater to update cars in a CSV file
 * @author Prabhjot Aulakh, Safin Haque
 */
public class FileCarUpdater implements ICarUpdater {
    private FileLoader fileLoader;
    
    /**
     * Constructor
     * @param fileLoader Loads data from a file to overwrite it 
     */
    public FileCarUpdater(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    /**
     * Creates a car in a CSV file
     * @param car Car to create/append to the CSV
     * @throws LoaderException If file IO error occurs
     */
    @Override
    public void create(Car car) throws LoaderException {
        String placeholder = null;
        placeholder = "\n" + this.getCarAsCsv(car);
        try {
            Files.write(Paths.get(Constants.CARS_CSV), placeholder.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    /**
     * Updates/overwrites CSV files to update a car
     * @param car Newly updated car data
     * @param index Index/row of the CSV file to update
     * @throws LoaderException If file IO error occurs
     */
    @Override
    public void update(Car car, int index) throws LoaderException {
        try {
            List<String> data = new ArrayList<String>();
            List<Car> cars = this.fileLoader.getCars();
            cars.set(index, car);
            for (Car c : cars) {
                data.add(this.getCarAsCsv(c));
            }
            String line = String.join("\n", data);
            Files.write(Paths.get(Constants.CARS_CSV), line.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new LoaderException(e);
        }        
    }

    /**
     * Deletes a car in a CSV file
     * @param index Row index/id to delete
     * @throws LoaderException If file IO error occurs
     */
    @Override
    public void delete(int index) throws LoaderException {
        try {
            List<String> data = new ArrayList<String>();
            List<Car> cars = this.fileLoader.getCars();
            cars.remove(index);
            for (Car c : cars) {
                data.add(this.getCarAsCsv(c));
            }
            String line = String.join("\n", data);
            Files.write(Paths.get(Constants.CARS_CSV), line.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    /**
     * Returns a car with all it's properties as comma seperated values
     * @param car Car to get CSV values from
     */
    private String getCarAsCsv(Car car) {
        if (!(car instanceof ElectricCar) && !(car instanceof RecreationalVehicle)) {
            return Constants.CAR_TYPE + "," + car.getModel() + "," + car.getYear() + "," + car.getColor() + "," + car.getPrice();
        } else if (car instanceof ElectricCar) {
            ElectricCar e = (ElectricCar) car;
            return Constants.ELECTRIC_TYPE + "," + e.getModel() + "," + e.getYear() + "," + e.getColor() + "," + e.getPrice() + "," + e.getVoltage() + "," + e.getChargerType();
        } else {
            RecreationalVehicle rv = (RecreationalVehicle) car;
            return Constants.RV_TYPE + "," + rv.getModel() + "," + rv.getYear() + "," + rv.getColor() + "," + rv.getPrice() + "," + rv.getMaxPassengers() + "," + rv.getNumberOfBeds() + "," + rv.isHasKitchen();
        }
    }
}
