package com.dealer.display;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealer.business.AdminManager;
import com.dealer.business.Manager;
import com.dealer.data.Source;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.impl.CarColorFilter;
import com.dealer.data.filters.impl.CarModelFilter;
import com.dealer.data.filters.impl.CarPriceFilter;
import com.dealer.data.filters.impl.CarVoltageFilter;
import com.dealer.data.filters.impl.CarYearFilter;
import com.dealer.data.filters.impl.ChargerTypeFilter;
import com.dealer.data.filters.impl.CustomerNameFilter;
import com.dealer.data.filters.impl.CustomerPhoneFilter;
import com.dealer.data.filters.impl.RVKitchenFilter;
import com.dealer.data.filters.impl.RVMaxPassengersFilter;
import com.dealer.data.filters.impl.RVNumberOfBedsFilter;
import com.dealer.data.filters.impl.TypeElectricCarFilter;
import com.dealer.data.filters.impl.TypeRVFilter;
import com.dealer.data.filters.impl.TypeRegularCarFilter;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.people.Customer;
import com.dealer.data.sorters.Order;
import com.dealer.data.sorters.impl.CarChargerTypeSorter;
import com.dealer.data.sorters.impl.CarMaxPassengersSorter;
import com.dealer.data.sorters.impl.CarModelSorter;
import com.dealer.data.sorters.impl.CarNumberOfBedsSorter;
import com.dealer.data.sorters.impl.CarPriceSorter;
import com.dealer.data.sorters.impl.CarVoltageSorter;
import com.dealer.data.sorters.impl.CarYearSorter;
import com.dealer.data.sorters.impl.CustomerNameSorter;

public class AdminApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {    
        Utils.greet();
        mainLoop(new AdminManager(Source.CSV));
        //app.run();
    }

    private static void mainLoop(AdminManager app) {
        while (true) {
            Utils.printOptions();
            System.out.print("Please choose an option: ");
            try {
                int input = getInput();
                if (input == Options.VIEW_CARS.getCode()) viewCars(app);
                else if (input == Options.FILTER_CARS.getCode()) filterCars(app);
                else if (input == Options.VIEW_CUSTOMERS.getCode()) viewCustomers(app);
                else if (input == Options.)
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            }
        }
    }

    private static void viewCars(AdminManager app) {
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
                List<Car> cars = app.getDataLoader().getCars();
                int input = getInput();
                if (input == NO_SORTING) {
                    Utils.printCars(cars);
                    break;
                } 
                else if (input == SORT_BY_MODEL) app.setAbstractCarSorter(new CarModelSorter(askOrder()));
                else if (input == SORT_BY_PRICE) app.setAbstractCarSorter(new CarPriceSorter(askOrder()));
                else if (input == SORT_BY_YEAR) app.setAbstractCarSorter(new CarYearSorter(askOrder()));
                else if (input == SORT_BY_VOLTAGE) app.setAbstractCarSorter(new CarVoltageSorter(askOrder()));
                else if (input == SORT_BY_CHARGER_TYPE) app.setAbstractCarSorter(new CarChargerTypeSorter(askOrder()));
                else if (input == SORT_BY_MAX_PASSENGERS) app.setAbstractCarSorter(new CarMaxPassengersSorter(askOrder()));
                else if (input == SORT_BY_NUMBER_OF_BEDS) app.setAbstractCarSorter(new CarNumberOfBedsSorter(askOrder()));
                else throw new NumberFormatException();
                if (app.getAbstractCarSorter() instanceof CarVoltageSorter || app.getAbstractCarSorter() instanceof CarChargerTypeSorter) {
                    app.setCarFilter(new TypeElectricCarFilter());
                    cars = app.getCarFilter().filterCars(cars);
                } 
                else if (app.getAbstractCarSorter() instanceof CarMaxPassengersSorter || app.getAbstractCarSorter() instanceof CarNumberOfBedsSorter) {
                    app.setCarFilter(new TypeRVFilter());
                    cars = app.getCarFilter().filterCars(cars);
                }
                app.getAbstractCarSorter().sortCars(cars);
                Utils.printCars(cars);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            } 
        }    
    }

    private static void filterCars(AdminManager app) {
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
                List<Car> cars = app.getDataLoader().getCars();
                int input = getInput();
                if (input == FILTER_COLOR) app.setCarFilter(new CarColorFilter(askStringQuery()));
                else if (input == FILTER_MODEL) app.setCarFilter(new CarModelFilter(askStringQuery()));
                else if (input == FILTER_PRICE) app.setCarFilter(new CarPriceFilter(askFilterOperation(), askIntQuery()));
                else if (input == FILTER_VOLTAGE) app.setCarFilter(new CarVoltageFilter(askFilterOperation(), askIntQuery()));
                else if (input == FILTER_YEAR) app.setCarFilter(new CarYearFilter(askFilterOperation(), askIntQuery()));
                else if (input == FILTER_CHARGER) app.setCarFilter(new ChargerTypeFilter(askStringQuery()));
                else if (input == FILTER_KITCHEN) app.setCarFilter(new RVKitchenFilter(true));
                else if (input == FILTER_MAX_PASSENGERS) app.setCarFilter(new RVMaxPassengersFilter(askFilterOperation(), askIntQuery()));
                else if (input == FILTER_NUM_BEDS) app.setCarFilter(new RVNumberOfBedsFilter(askFilterOperation(), askIntQuery()));
                else if (input == FILTER_NUM_BEDS) app.setCarFilter(new TypeRegularCarFilter());
                else if (input == FILTER_ELECTRIC) app.setCarFilter(new TypeElectricCarFilter());
                else if (input == FILTER_RV) app.setCarFilter(new TypeRVFilter());
                else throw new NumberFormatException();
                cars = app.getCarFilter().filterCars(cars);
                Utils.printCars(cars);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    private static void viewCustomers(AdminManager app) {
        final int NO_SORTING = 1;
        final int SORT_BY_NAME = 2;
        while (true) {
            System.out.println(NO_SORTING + ": Skip sorting");
            System.out.println(SORT_BY_NAME + ": Sort by name");
            System.out.print(">>>> ");
            try {
                List<Customer> customers = app.getDataLoader().getCustomers();
                int input = getInput();
                if (input == NO_SORTING) {
                    Utils.printCustomers(customers);
                    break;
                } 
                else if (input == SORT_BY_NAME) app.setAbstractCustomerSorter(new CustomerNameSorter(askOrder()));
                else throw new NumberFormatException();
                app.getAbstractCustomerSorter().sortCustomers(customers);
                Utils.printCustomers(customers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    private void filterCustomers(AdminManager app) {
        final int FILTER_NAME = 1;
        final int FILTER_PHONE = 2;
        while (true) {
            System.out.println(FILTER_NAME + ": filter by name");
            System.out.println(FILTER_PHONE + ": filter by phone");
            System.out.print(">>>> ");
            try {
                List<Customer> customers = app.getDataLoader().getCustomers();
                int input = getInput();
                if (input == FILTER_NAME) {
                    this.setCustomerFilter(new CustomerNameFilter(askStringQuery()));
                } else if (input == FILTER_PHONE) {
                    this.setCustomerFilteringStrategy(new CustomerPhoneFilter(this.askStringQuery()));
                } else {
                    throw new NumberFormatException();
                }
                customers = this.customerFilter.filterCustomers(customers);
                printCustomers(customers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getInput() throws NumberFormatException {
        return Integer.parseInt(sc.nextLine());
    }

    private static Order askOrder() {
        final int ASCENDING = 1;
        final int DESCENDING = 2;
        while (true) {
            try {
                System.out.println(ASCENDING + " for ascending order");
                System.out.println(DESCENDING + " for descending order");
                System.out.print(">>>> ");
                int input = getInput();
                if (input == ASCENDING) return Order.ASCENDING;
                else if (input == DESCENDING) return Order.DESCENDING;
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            }  
        }
    }

    private static String askStringQuery() {
        System.out.print("Enter String query: ");
        return sc.nextLine();
    }

    private static int askIntQuery() throws NumberFormatException {
        System.out.print("Enter number to query by: ");
        return Integer.parseInt(sc.nextLine());
    }

    private static ListFilter askFilterOperation() {
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
                int input = getInput();
                if (input == EQUALS) return ListFilter.EQUALS;
                else if (input == GREATER) return ListFilter.GREATERTHAN;
                else if (input == LESS) return ListFilter.LESSTHAN;
                else if (input == GREATER_EQUALS) return ListFilter.GREATEREQUALS;
                else if (input == LESS_EQUALS) return ListFilter.LESSEQUALS;
                else throw new InputMismatchException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            }
        }
    }
}
