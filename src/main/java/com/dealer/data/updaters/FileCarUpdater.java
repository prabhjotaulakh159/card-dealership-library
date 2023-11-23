package com.dealer.data.updaters;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.FileLoader;
import com.dealer.models.cars.Car;

public class FileCarUpdater implements ICarUpdater {
    private FileLoader fileLoader;
    
    @Override
    public void create(Car car) throws LoaderException {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void update(Car car, int index) throws LoaderException {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int index) throws LoaderException {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
