package com.dealer.data.updaters;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.models.cars.Car;

public interface ICarUpdater {
    void create(Car car) throws LoaderException;
    void update(Car car, int index) throws LoaderException;
    void delete(int index) throws LoaderException;
}
