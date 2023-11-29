package com.dealer.business;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealer.data.Source;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.impl.CarColorFilter;
import com.dealer.data.filters.impl.CarModelFilter;
import com.dealer.data.filters.impl.CarPriceFilter;
import com.dealer.data.filters.impl.CarVoltageFilter;
import com.dealer.data.filters.impl.CarYearFilter;
import com.dealer.data.filters.impl.ChargerTypeFilter;
import com.dealer.data.filters.impl.RVKitchenFilter;
import com.dealer.data.filters.impl.RVMaxPassengersFilter;
import com.dealer.data.filters.impl.RVNumberOfBedsFilter;
import com.dealer.data.filters.impl.TypeElectricCarFilter;
import com.dealer.data.filters.impl.TypeRVFilter;
import com.dealer.data.filters.impl.TypeRegularCarFilter;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.data.models.cars.Car;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.Order;
import com.dealer.data.updaters.FileCarUpdater;
import com.dealer.data.updaters.ICarUpdater;
import com.dealer.data.updaters.OracleCarUpdater;

/**
 * Provides the main functionality of the manager class for both admins and employees (mainly querying for cars)
 * and other helper methods useful for both admins and employees
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class Manager {
    protected IDataLoader dataLoader;
    protected ICarUpdater carUpdater;
    protected AbstractCarSorter abstractCarSorter;
    protected AbstractCustomerSorter abstractCustomerSorter;
    protected AbstractEmployeeSorter abstractEmployeeSorter; 
    protected ICarFilter carFilter;
    protected ICustomerFilter customerFilter;
    protected IEmployeeFilter employeeFilter;
    protected Scanner scanner;

    protected final int CAR_OPTION = 1;
    protected final int CAR_FILTER_OPTION = 2;

    /**
     * Constructor
     * @param dataLoader Strategy for loading data from a source (file/oracle)
     */
    public Manager(Source source) {
        if (source == Source.CSV) {
            this.dataLoader = new FileLoader();
            this.carUpdater = new FileCarUpdater((FileLoader) this.dataLoader);
        } else if (source == Source.ORACLE) {
            this.dataLoader = new OracleLoader();
            this.carUpdater = new OracleCarUpdater();
        }
        this.abstractCarSorter = null;
        this.abstractCustomerSorter = null;
        this.abstractEmployeeSorter = null;
        this.carFilter = null;
        this.customerFilter = null;
        this.employeeFilter = null;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Entry point of the manager class
     */
    public abstract void run();
    
    /**
     * Prints a list of cars on the terminal
     * @param cars List of cars to be printed
     */
    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

     /**
     * Prompts the user to ask if the sorting should be ascending or descending
     * @return Order of sorting
     */
    public Order askOrder() {
        final int ASCENDING = 1;
        final int DESCENDING = 2;
        while (true) {
            try {
                System.out.println(ASCENDING + " for ascending order");
                System.out.println(DESCENDING + " for descending order");
                System.out.print(">>>> ");
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == ASCENDING) {
                    return Order.ASCENDING;
                } else if (input == DESCENDING) {
                    return Order.DESCENDING;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            }  
        }
    }

    /**
     * Prompts users to query for string data
     * @return The query string
     */
    public String askStringQuery() {
        System.out.print("Enter String query: ");
        return this.scanner.nextLine();
    }

    /**
     * Prompts users to query for integer related data
     * @return Integer query
     */
    public int askIntQuery() {
        System.out.print("Enter number to query by: ");
        return Integer.parseInt(this.scanner.nextLine());
    }

    /**
     * Prompts users to query by a certain boolean operation
     * @return The boolean operation for filtering
     */
    public ListFilter askFilterOperation() {
        final int EQUALS = 1;
        final int GREATER = 2;
        final int LESS = 3;
        final int GREATER_EQUALS = 4;
        final int LESS_EQUALS = 5;
        while (true) {
            System.out.println(EQUALS + " for equals");
            System.out.println(GREATER + " for greater");
            System.out.println(LESS + " for less");
            System.out.println(GREATER_EQUALS + " for greater equals");
            System.out.println(LESS_EQUALS + " for less equals");
            System.out.print(">>>> ");
            try {
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == EQUALS) {
                    return ListFilter.EQUALS;
                } else if (input == GREATER) {
                    return ListFilter.GREATERTHAN;
                } else if (input == LESS) {
                    return ListFilter.LESSTHAN;
                } else if (input == GREATER_EQUALS) {
                    return ListFilter.GREATEREQUALS;
                } else if (input == LESS_EQUALS) {
                    return ListFilter.LESSEQUALS;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            }
        }
    }

    /**
     * Used to close resources
     */
    public void killResources(){
   
        if (this.dataLoader instanceof OracleLoader){
            try{
                ((OracleLoader) this.dataLoader).getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public IDataLoader getDataLoader() {
        return dataLoader;
    }

    public ICarUpdater getCarUpdater() {
        return carUpdater;
    }

    public AbstractCarSorter getAbstractCarSorter() {
        return abstractCarSorter;
    }

    public void setAbstractCarSorter(AbstractCarSorter abstractCarSorter) {
        this.abstractCarSorter = abstractCarSorter;
    }

    public AbstractCustomerSorter getAbstractCustomerSorter() {
        return abstractCustomerSorter;
    }

    public void setAbstractCustomerSorter(AbstractCustomerSorter abstractCustomerSorter) {
        this.abstractCustomerSorter = abstractCustomerSorter;
    }

    public AbstractEmployeeSorter getAbstractEmployeeSorter() {
        return abstractEmployeeSorter;
    }

    public void setAbstractEmployeeSorter(AbstractEmployeeSorter abstractEmployeeSorter) {
        this.abstractEmployeeSorter = abstractEmployeeSorter;
    }

    public ICarFilter getCarFilter() {
        return carFilter;
    }

    public void setCarFilter(ICarFilter carFilter) {
        this.carFilter = carFilter;
    }

    public ICustomerFilter getCustomerFilter() {
        return customerFilter;
    }

    public void setCustomerFilter(ICustomerFilter customerFilter) {
        this.customerFilter = customerFilter;
    }

    public IEmployeeFilter getEmployeeFilter() {
        return employeeFilter;
    }

    public void setEmployeeFilter(IEmployeeFilter employeeFilter) {
        this.employeeFilter = employeeFilter;
    }
}
