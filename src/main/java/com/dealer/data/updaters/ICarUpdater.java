package com.dealer.data.updaters;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.models.cars.Car;

/**
 * Defines methods to update cars in various different sources (db/file)
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICarUpdater {
    /**
     * Creates a car
     * @param car Car to create
     * @throws LoaderException If IO/SQL errors occur
     */
    void create(Car car) throws LoaderException;

    /**
     * Updates a car at a certain index in the db
     * @param car New car information
     * @param index Index of the car to update
     * @throws LoaderException If IO/SQL errors occur
     */
    void update(Car car, int index) throws LoaderException;

    /**
     * Deletes a car at an index
     * @param index Index to delete car at
     * @throws LoaderException If IO/SQL errors occur
     */
    void delete(int index) throws LoaderException;
}
