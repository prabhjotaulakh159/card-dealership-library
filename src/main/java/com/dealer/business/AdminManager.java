package com.dealer.business;


import java.util.List;

import com.dealer.data.Mode;
import com.dealer.data.Source;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.people.Customer;
import com.dealer.data.models.people.Employee;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.updaters.FileCarUpdater;
import com.dealer.data.updaters.ICarUpdater;
import com.dealer.data.updaters.OracleCarUpdater;

/**
 * Manager class for admins, which allows them to not only query cars, 
 * but also update them. It also allows them to query customers and employees.
 * @author Prabhjot Aulakh, Safin Haque
 */
public class AdminManager extends Manager {
    private ICarUpdater carUpdater;
    private ICustomerFilter customerFilter;
    private IEmployeeFilter employeeFilter;
    private AbstractCustomerSorter abstractCustomerSorter;
    private AbstractEmployeeSorter abstractEmployeeSorter;

    /**
     * Constructor which provides the updater for cars a destination that is a file if the destination is set to CSV, 
     * else it is an Oracle database
     * @param source The source of the data
     */
    public AdminManager(Source source) {
        super(source);
        this.carUpdater = source == Source.CSV ? new FileCarUpdater((FileLoader) super.getDataLoader()) : new OracleCarUpdater();
    }

    /**
     * Sets the strategy for sorting customers
     * @param abstractCustomerSorter The strategy for sorting customers
     */
    public void customerSortingStrategy(AbstractCustomerSorter abstractCustomerSorter) {
        this.abstractCustomerSorter = abstractCustomerSorter;
    }   

    /**
     * Sets the strategy for filtering customers
     * @param customerFilter The strategy for filtering customers
     */
    public void customerFilteringStrategy(ICustomerFilter customerFilter) {
        this.customerFilter = customerFilter;
    }

    /**
     * Sets the strategy for sorting employees
     * @param abstractEmployeeSorter The strategy for sorting employees
     */
    public void employeeSortingStrategy(AbstractEmployeeSorter abstractEmployeeSorter) {
        this.abstractEmployeeSorter = abstractEmployeeSorter;
    }

    /**
     * Sets the strategy for filtering employees
     * @param employeeFilter The strategy for filtering employees
     */
    public void employeeFilteringStrategy(IEmployeeFilter employeeFilter) {
        this.employeeFilter = employeeFilter;
    }
    
    /**
     * Sorts customers
     * @param customers The customers to sort
     */
    public void sortCustomers(List<Customer> customers) {
        this.abstractCustomerSorter.sortCustomers(customers);
    }

    /**
     * Filters customers
     * @param customers The customers to filter
     * @return The filtered customers
     */
    public List<Customer> filterCustomers(List<Customer> customers) {
        return this.customerFilter.filterCustomers(customers);
    }

    /**
     * Sorts employees
     * @param employees The employees to sort
     */
    public void sortEmployees(List<Employee> employees) {
        this.abstractEmployeeSorter.sortEmployees(employees);
    }

    /**
     * Filters employees
     * @param employees The employees to filter
     * @return The filtered employees
     */
    public List<Employee> filterEmployees(List<Employee> employees) {
        return this.employeeFilter.filterEmployees(employees);
    }

    /**
     * Returns the list of customers from source
     * @return The list of customers from source
     * @throws LoaderException If there is an error while loading the data
     */
    public List<Customer> customers() throws LoaderException {
        return this.getDataLoader().getCustomers(Mode.PRODUCTION);
    }

    /**
     * Returns the list of employees from source
     * @return The list of employees from source
     * @throws LoaderException If there is an error while loading the data
     */
    public List<Employee> employees() throws LoaderException {
        return this.getDataLoader().getEmployees(Mode.PRODUCTION);
    }

    /**
     * Creates a car 
     * @param car Car to create
     * @throws LoaderException If writing to source fails
     */
    public void createCar(Car car) throws LoaderException {
        this.carUpdater.create(car, Mode.PRODUCTION);
    }

    /**
     * Updates a car
     * @param car Car to update
     * @param index Index of car to update
     * @throws LoaderException If writing to source fails
     */
    public void updateCar(Car car, int index) throws LoaderException {
        if (super.getDataLoader() instanceof FileLoader) index = index - 1;
        this.carUpdater.update(car, index, Mode.PRODUCTION);
    }

    /**
     * Deletes a car
     * @param index Index of car to delete
     * @throws LoaderException If writing to source fails
     */
    public void deleteCar(int index) throws LoaderException {
        if (super.getDataLoader() instanceof FileLoader) index = index - 1;
        this.carUpdater.delete(index, Mode.PRODUCTION);
    }
}
