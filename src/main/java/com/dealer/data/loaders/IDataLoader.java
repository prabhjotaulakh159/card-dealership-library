package com.dealer.data.loaders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dealer.data.Mode;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.people.Customer;
import com.dealer.data.models.people.Employee;

/**
 * Fetches data from a source (db or file) and stores them in lists
 * @author Prabhjot Aulakh, Safin Haque
 */
public interface IDataLoader {
    /**
     * Retrives the list of cars in source
     * @param mode Determine if loading should be done with test or production files
     * @return All the cars in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    List<Car> getCars(Mode mode) throws LoaderException;

    /**
     * Retrives the list of customer in source
     * @param mode Determine if loading should be done with test or production files
     * @return All the customers in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    List<Customer> getCustomers(Mode mode) throws LoaderException;

    /**
     * Retrives the list of employees in source
     * @param mode Determine if loading should be done with test or production files
     * @return All the employees in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    List<Employee> getEmployees(Mode mode) throws LoaderException;
}
