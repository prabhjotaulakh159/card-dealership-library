package com.dealer.data.updaters;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.dealer.data.Constants;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Implements ICarUpdater to update cars in a CSV file
 */
public class FileCarUpdater implements ICarUpdater {
    /**
     * Updates cars in a csv file
     * @param cars Newly updated cars
     * @throws LoaderException If IOException occurs
     */
    @Override
    public void updateCars(List<Car> cars) throws LoaderException {
        try {
            Path path = Paths.get("src\\main\\java\\com\\dealer\\resources\\cars.csv");
            List<String> commaSeperatedCars = new ArrayList<String>();
            for (Car car : cars) {
                if (!(car instanceof ElectricCar) && !(car instanceof RecreationalVehicle)) {
                    commaSeperatedCars.add(Constants.CAR_TYPE + "," + car.getModel() + "," + car.getYear() + "," + car.getColor() + "," + car.getPrice());
                } else if (car instanceof ElectricCar) {
                    ElectricCar e = (ElectricCar) car;
                    commaSeperatedCars.add(Constants.ELECTRIC_TYPE + "," + e.getModel() + "," + e.getYear() + "," + e.getColor() + "," + e.getPrice() + "," + e.getVoltage() + "," + e.getChargerType());
                } else if (car instanceof RecreationalVehicle) {
                    RecreationalVehicle rv = (RecreationalVehicle) car;
                    commaSeperatedCars.add(Constants.RV_TYPE + "," + rv.getModel() + "," + rv.getYear() + "," + rv.getColor() + "," + rv.getPrice() + "," + rv.getMaxPassengers() + "," + rv.getNumberOfBeds() + "," + rv.isHasKitchen());
                }
            }
            // Extra operation to avoid extra line at the end of file over-writing
            String data = String.join("\n", commaSeperatedCars);
            Files.write(path, data.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new LoaderException(e);
        }
    }
}
