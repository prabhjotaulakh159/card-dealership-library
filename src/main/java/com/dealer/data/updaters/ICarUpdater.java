package com.dealer.data.updaters;

import com.dealer.data.Mode;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;

/**
 * Defines methods to update cars in various different sources (db/file)
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface ICarUpdater {
    /**
     * Creates a car
     * @param car Car to create
     * @param mode determines if dataLoading is running in test or production
     * @throws LoaderException If IO/SQL errors occur
     */
    void create(Car car, Mode mode) throws LoaderException;

    /**
     * Updates a car at a certain index in the db
     * @param car New car information
     * @param index Index of the car to update
     * @param mode determines if dataLoading is running in test or production
     * @throws LoaderException If IO/SQL errors occur
     */
    void update(Car car, int index, Mode mode) throws LoaderException;

    /**
     * Deletes a car at an index
     * @param index Index to delete car at
     * @param mode determines if dataLoading is running in test or production
     * @throws LoaderException If IO/SQL errors occur
     */
    void delete(int index, Mode mode) throws LoaderException;
}
