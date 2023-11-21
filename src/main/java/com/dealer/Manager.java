package com.dealer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.impl.TypeElectricCarFilter;
import com.dealer.data.filters.impl.TypeRVFilter;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.Order;
import com.dealer.data.sorters.impl.CarChargerTypeSorter;
import com.dealer.data.sorters.impl.CarMaxPassengersSorter;
import com.dealer.data.sorters.impl.CarModelSorter;
import com.dealer.data.sorters.impl.CarNumberOfBedsSorter;
import com.dealer.data.sorters.impl.CarPriceSorter;
import com.dealer.data.sorters.impl.CarVoltageSorter;
import com.dealer.data.sorters.impl.CarYearSorter;
import com.dealer.models.cars.Car;

/**
 * Manager class for admins
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Manager {
    private IDataLoader dataLoader;
    private AbstractCarSorter abstractCarSorter;
    private AbstractCustomerSorter abstractCustomerSorter;
    private AbstractEmployeeSorter abstractEmployeeSorter; 
    private ICarFilter carFilter;
    private ICustomerFilter customerFilter;
    private IEmployeeFilter employeeFilter;
    private Scanner scanner;

    private final int CAR_OPTION = 1;
    private final int CAR_FILTER_OPTION = 1;
    private final int CUSTOMER_OPTION = 2;
    private final int EMPLOYEE_OPTION = 3;
    private final int QUIT = 4;

    /**
     * Constructor
     * @param dataLoader Strategy for loading data from a source (file/oracle)
     */
    public Manager(IDataLoader dataLoader) {
        this.dataLoader = dataLoader;
        this.abstractCarSorter = null;
        this.abstractCustomerSorter = null;
        this.abstractEmployeeSorter = null;
        this.carFilter = null;
        this.customerFilter = null;
        this.employeeFilter = null;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Sets the sorting strategy for cars
     * @param sorter Strategy for sorting cars
     */
    public void setCarSortingStrategy(AbstractCarSorter sorter) { 
        this.abstractCarSorter = sorter;
    }

    /**
     * Sets the sorting strategy for customers
     * @param sorter Strategy for sorting customers
     */
    public void setCustomerSortingStrategy(AbstractCustomerSorter sorter) { 
        this.abstractCustomerSorter = sorter;
    }

    /**
     * Sets the sorting strategy for employees
     * @param sorter Strategy for sorting employees
     */
    public void setEmployeeSortingStrategy(AbstractEmployeeSorter sorter) { 
        this.abstractEmployeeSorter = sorter;
    }

    /**
     * Sets the filtering strategy for cars
     * @param filter Strategy for filtering cars
     */
    public void setCarFilteringStrategy(ICarFilter filter) { 
        this.carFilter = filter;
    }

    /**
     * Sets the filtering strategy for customers
     * @param filter Strategy for filtering customers
     */
    public void setCustomerFilteringStrategy(ICustomerFilter filter) { 
        this.customerFilter = filter;
    }

    /**
     * Sets the filtering strategy for employees
     * @param filter Strategy for filtering employees
     */
    public void setEmployeeFilteringStrategy(IEmployeeFilter filter) { 
        this.employeeFilter = filter;
    }

    /**
     * Entry point of the manager class
     */
    public void run() {
        System.out.println("Welcome to car inventory manager!");
        while (true) {
            System.out.println(this.CAR_OPTION + ": view cars");
            System.out.println(this.CAR_FILTER_OPTION + ": filter cars");
            System.out.println(this.CUSTOMER_OPTION + ": view customers");
            System.out.println(this.EMPLOYEE_OPTION + ": view employees");
            System.out.println(this.QUIT + ": quit");
            System.out.print("Please choose an option from above >>> ");
            try {
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == this.CAR_OPTION) {
                    this.queryCars();
                } else if (input == this.CAR_FILTER_OPTION) {
                    this.filterCars();
                } else if (input == this.CUSTOMER_OPTION) {
                    System.out.println(2);
                } else if (input == this.EMPLOYEE_OPTION) {
                    System.out.println(3);
                } else if (input == QUIT) {
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            } 
        }
        System.out.println("Good bye !");
    }

    /**
     * Provides UI for querying cars by sorting
     */
    private void queryCars() {
        final int NO_SORTING = 1;
        final int SORT_BY_MODEL = 2;
        final int SORT_BY_PRICE = 3;
        final int SORT_BY_YEAR = 5;
        final int SORT_BY_VOLTAGE = 6;
        final int SORT_BY_CHARGER_TYPE = 7;
        final int SORT_BY_MAX_PASSENGERS = 8;
        final int SORT_BY_NUMBER_OF_BEDS = 9;
        while (true) {
            System.out.println(NO_SORTING + ": Skip sorting");
            System.out.println(SORT_BY_MODEL + ": Sort by model");
            System.out.println(SORT_BY_PRICE + ": Sort by price");
            System.out.println(SORT_BY_YEAR + ": Sort by year");
            System.out.println(SORT_BY_VOLTAGE + ": Sort by voltage");
            System.out.println(SORT_BY_CHARGER_TYPE + ": Sort by charger type");
            System.out.println(SORT_BY_MAX_PASSENGERS + ": Sort by max passengers");
            System.out.println(SORT_BY_NUMBER_OF_BEDS + ": Sort by number of beds");
            System.out.println(">>>>> ");
            try {
                List<Car> cars = this.dataLoader.getCars();
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == NO_SORTING) {
                    printCars(cars);
                } else if (input == SORT_BY_MODEL) {
                    this.setCarSortingStrategy(new CarModelSorter(this.askOrder()));
                } else if (input == SORT_BY_PRICE) {
                    this.setCarSortingStrategy(new CarPriceSorter(this.askOrder()));
                } else if (input == SORT_BY_YEAR) {
                    this.setCarSortingStrategy(new CarYearSorter(this.askOrder()));
                } else if (input == SORT_BY_VOLTAGE) {
                    this.setCarSortingStrategy(new CarVoltageSorter(this.askOrder()));
                } else if (input == SORT_BY_CHARGER_TYPE) {
                    this.setCarSortingStrategy(new CarChargerTypeSorter(this.askOrder()));
                } else if (input == SORT_BY_MAX_PASSENGERS) {
                    this.setCarSortingStrategy(new CarMaxPassengersSorter(this.askOrder()));
                } else if (input == SORT_BY_NUMBER_OF_BEDS) {
                    this.setCarSortingStrategy(new CarNumberOfBedsSorter(this.askOrder()));
                } else {
                    throw new InputMismatchException();
                }
                if (this.abstractCarSorter instanceof CarVoltageSorter || this.abstractCarSorter instanceof CarChargerTypeSorter) {
                    this.setCarFilteringStrategy(new TypeElectricCarFilter());
                    cars = this.carFilter.filterCars(cars);
                } else if (this.abstractCarSorter instanceof CarMaxPassengersSorter || this.abstractCarSorter instanceof CarNumberOfBedsSorter) {
                    this.setCarFilteringStrategy(new TypeRVFilter());
                    cars = this.carFilter.filterCars(cars);
                }
                this.abstractCarSorter.sortCars(cars);
                printCars(cars);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            } catch (LoaderException e) {
                e.printStackTrace();
            } 
        }
    }

    /**
     * Provides UI for filtering cars
     */
    private void filterCars() {
        final int FILTER_COLOR = 1;
        final int FILTER_MODEL = 2;
        final int FILTER_PRICE = 3;
        final int FILTER_VOLTAGE = 4;
        final int FILTER_YEAR = 5;
        final int FILTER_KITCHEN = 6;
        final int FILTER_MAX_PASSENGERS = 7;
        final int FILTER_NUM_BEDS = 8;
        final int FILTER_REGULAR_CARS = 9;
        final int FILTER_ELECTRIC = 10;
        final int FILTER_RV = 11;
        while (true) {
            System.out.println(FILTER_COLOR + ": filter by color");
            System.out.println(FILTER_MODEL + ": filter by model");
            System.out.println(FILTER_PRICE + ": filter by price");
            System.out.println(FILTER_VOLTAGE + ": filter by voltage");
            System.out.println(FILTER_YEAR + ": filter by year");
            System.out.println(FILTER_KITCHEN + ": filter RV that have kitchens");
            System.out.println(FILTER_MAX_PASSENGERS + ": filter by RV max passengers");
            System.out.println(FILTER_NUM_BEDS + ": filter by RV number of beds");
            System.out.println(FILTER_REGULAR_CARS + ": filter regular cars");
            System.out.println(FILTER_ELECTRIC + ": filter electric cars");
            System.out.println(FILTER_RV + ": filter RV's");
            try {
                List<Car> cars = this.dataLoader.getCars();
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Prints a list of cars on the terminal
     * @param cars List of cars to be printed
     */
    private void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    /**
     * Prompts the user to ask if the sorting should be ascending or descending
     * @return Order of sorting
     */
    private Order askOrder() {
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
}
