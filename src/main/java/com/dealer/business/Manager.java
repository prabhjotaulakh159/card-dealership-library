package com.dealer.business;

import java.sql.SQLException;
import java.util.List;

import com.dealer.data.Mode;
import com.dealer.data.Source;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ICarFilter;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.data.models.cars.Car;
import com.dealer.data.sorters.AbstractCarSorter;


/**
 * Provides the main functionality of the manager class for both admins and employees (mainly querying for cars)
 */
public abstract class Manager {
    private IDataLoader dataLoader;
    private ICarFilter carFilter;
    private AbstractCarSorter abstractCarSorter; 

    /**
     * Constructor, which provides the source of data as a file if the source is set to CSV, 
     * else it is an Oracle database
     * @param source Source of data
     */
    public Manager(Source source) {
        this.dataLoader = source == Source.CSV ? new FileLoader() : new OracleLoader();
    }

    /**
     * Returns list of cars from source
     * @return List of cars from source
     * @throws LoaderException If fetching resources fail
     */
    public List<Car> cars() throws LoaderException {
        return this.dataLoader.getCars(Mode.PRODUCTION);
    }

    /**
     * Sorts a list of cars 
     * @param cars Cars to sort
     */
    public void sortCars(List<Car> cars) {
        this.abstractCarSorter.sortCars(cars);
    }

    /**
     * Filters a list of cars
     * @param cars Cars to filter
     * @return Filtered cars
     */
    public List<Car> filterCars(List<Car> cars) {
        return this.carFilter.filterCars(cars);
    }
    
    /**
     * Sets the strategy for sorting cars
     * @param abstractCarSorter Strategy for sorting cars
     */
    public void carSortingStrategy(AbstractCarSorter abstractCarSorter) {
        this.abstractCarSorter = abstractCarSorter;
    }

    /**
     * Sets the strategy for filtering cars
     * @param carFilter Strategy for filtering cars
     */
    public void carFilteringStrategy(ICarFilter carFilter) {
        this.carFilter = carFilter;
    }

    /**
     * Closes any open resources 
     */
    public void killResources()  {
        if (this.dataLoader instanceof OracleLoader) {
            try {
                ((OracleLoader) this.dataLoader).getConnection().close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns data loader, only accessible by it's children classes in the current package, 
     * as we do not want unrelated classes to call getDataLoader.getConnection(), which 
     * allows them to do almost anything to a database, hence why it's protected
     * @return Data loader
     */
    protected IDataLoader getDataLoader() {
        return dataLoader;
    }

    /**
     * Returns car filter
     * @return Car filter
     */
    public ICarFilter getCarFilter() {
        return carFilter;
    }

    /**
     * Returns car sorter
     * @return Car sorter
     */
    public AbstractCarSorter getAbstractCarSorter() {
        return abstractCarSorter;
    }
}
