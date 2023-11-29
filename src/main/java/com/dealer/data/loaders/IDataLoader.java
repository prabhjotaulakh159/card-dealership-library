package com.dealer.data.loaders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
     * @return All the cars in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    List<Car> getCars() throws LoaderException;

    /**
     * Retrives the list of customer in source
     * @return All the customers in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    List<Customer> getCustomers() throws LoaderException;

    /**
     * Retrives the list of employees in source
     * @return All the employees in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    List<Employee> getEmployees() throws LoaderException;
}
