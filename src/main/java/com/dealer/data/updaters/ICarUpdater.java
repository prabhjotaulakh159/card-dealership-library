package com.dealer.data.updaters;

import java.util.List;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.models.cars.Car;

/**
 * Provides an interface for updating cars in source (file/db)
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICarUpdater {
    /**
     * Updates cars in source (file/db)
     * @param cars Newly updated cars
     * @throws LoaderException If db/file writing error occurs
     */
    void updateCars(List<Car> cars) throws LoaderException;
}
