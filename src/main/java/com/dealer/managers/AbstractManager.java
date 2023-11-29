package com.dealer.managers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
import com.dealer.data.updaters.FileCarUpdater;
import com.dealer.data.updaters.ICarUpdater;
import com.dealer.data.updaters.OracleCarUpdater;
import com.dealer.models.cars.Car;

/**
 * Provides the main functionality of the manager class for both admins and employees (mainly querying for cars)
 * and other helper methods useful for both admins and employees
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class AbstractManager {
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
    public AbstractManager(IDataLoader dataLoader) {
        this.dataLoader = dataLoader;
        this.carUpdater = dataLoader instanceof FileLoader ? new FileCarUpdater((FileLoader)this.dataLoader) : new OracleCarUpdater();
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
    protected void setCarSortingStrategy(AbstractCarSorter sorter) { 
        this.abstractCarSorter = sorter;
    }

    /**
     * Sets the filtering strategy for cars
     * @param filter Strategy for filtering cars
     */
    protected void setCarFilteringStrategy(ICarFilter filter) { 
        this.carFilter = filter;
    }

    /**
     * Entry point of the manager class
     */
    public abstract void run();
    
    /**
     * Provides UI for querying cars by sorting
     */
    protected void queryCars() {
        final int NO_SORTING = 1;
        final int SORT_BY_MODEL = 2;
        final int SORT_BY_PRICE = 3;
        final int SORT_BY_YEAR = 4;
        final int SORT_BY_VOLTAGE = 5;
        final int SORT_BY_CHARGER_TYPE = 6;
        final int SORT_BY_MAX_PASSENGERS = 7;
        final int SORT_BY_NUMBER_OF_BEDS = 8;
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
                    break;
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
    protected void filterCars() {
        final int FILTER_COLOR = 1;
        final int FILTER_MODEL = 2;
        final int FILTER_PRICE = 3;
        final int FILTER_VOLTAGE = 4;
        final int FILTER_YEAR = 5;
        final int FILTER_CHARGER = 6;
        final int FILTER_KITCHEN = 7;
        final int FILTER_MAX_PASSENGERS = 8;
        final int FILTER_NUM_BEDS = 9;
        final int FILTER_REGULAR_CARS = 10;
        final int FILTER_ELECTRIC = 11;
        final int FILTER_RV = 12;
        while (true) {
            System.out.println(FILTER_COLOR + ": filter by color");
            System.out.println(FILTER_MODEL + ": filter by model");
            System.out.println(FILTER_PRICE + ": filter by price");
            System.out.println(FILTER_VOLTAGE + ": filter by voltage");
            System.out.println(FILTER_YEAR + ": filter by year");
            System.out.println(FILTER_CHARGER + ": filter by charger type");
            System.out.println(FILTER_KITCHEN + ": filter RV that have kitchens");
            System.out.println(FILTER_MAX_PASSENGERS + ": filter by RV max passengers");
            System.out.println(FILTER_NUM_BEDS + ": filter by RV number of beds");
            System.out.println(FILTER_REGULAR_CARS + ": filter regular cars");
            System.out.println(FILTER_ELECTRIC + ": filter electric cars");
            System.out.println(FILTER_RV + ": filter RV's");
            System.out.print(">>>> ");
            try {
                List<Car> cars = this.dataLoader.getCars();
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == FILTER_COLOR) {
                    this.setCarFilteringStrategy(new CarColorFilter(this.askStringQuery()));
                } else if (input == FILTER_MODEL) {
                    this.setCarFilteringStrategy(new CarModelFilter(this.askStringQuery()));
                } else if (input == FILTER_PRICE) {
                    this.setCarFilteringStrategy(new CarPriceFilter(this.askFilterOperation(), this.askIntQuery()));
                } else if (input == FILTER_VOLTAGE) {
                    this.setCarFilteringStrategy(new CarVoltageFilter(this.askFilterOperation(), this.askIntQuery()));
                } else if (input == FILTER_YEAR) {
                    this.setCarFilteringStrategy(new CarYearFilter(this.askFilterOperation(), this.askIntQuery()));
                } else if (input == FILTER_CHARGER) {
                    this.setCarFilteringStrategy(new ChargerTypeFilter(this.askStringQuery()));
                } else if (input == FILTER_KITCHEN) {
                    this.setCarFilteringStrategy(new RVKitchenFilter(true));
                } else if (input == FILTER_MAX_PASSENGERS) {
                    this.setCarFilteringStrategy(new RVMaxPassengersFilter(this.askFilterOperation(), this.askIntQuery()));
                } else if (input == FILTER_NUM_BEDS) {
                    this.setCarFilteringStrategy(new RVNumberOfBedsFilter(this.askFilterOperation(), this.askIntQuery()));
                } else if (input == FILTER_NUM_BEDS) {
                    this.setCarFilteringStrategy(new TypeRegularCarFilter());
                } else if (input == FILTER_ELECTRIC) {
                    this.setCarFilteringStrategy(new TypeElectricCarFilter());
                } else if (input == FILTER_RV) {
                    this.setCarFilteringStrategy(new TypeRVFilter());
                } else {
                    throw new InputMismatchException();
                }
                cars = this.carFilter.filterCars(cars);
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
     * Prints a list of cars on the terminal
     * @param cars List of cars to be printed
     */
    protected void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

     /**
     * Prompts the user to ask if the sorting should be ascending or descending
     * @return Order of sorting
     */
    protected Order askOrder() {
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
    protected String askStringQuery() {
        System.out.print("Enter String query: ");
        return this.scanner.nextLine();
    }

    /**
     * Prompts users to query for integer related data
     * @return Integer query
     */
    protected int askIntQuery() {
        System.out.print("Enter number to query by: ");
        return Integer.parseInt(this.scanner.nextLine());
    }

    /**
     * Prompts users to query by a certain boolean operation
     * @return The boolean operation for filtering
     */
    protected ListFilter askFilterOperation() {
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
}
