package com.dealer.display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.dealer.business.EmployeeManager;
import com.dealer.data.Source;
import com.dealer.data.exceptions.LoaderException;
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
import com.dealer.data.models.cars.Car;
import com.dealer.data.sorters.impl.CarChargerTypeSorter;
import com.dealer.data.sorters.impl.CarMaxPassengersSorter;
import com.dealer.data.sorters.impl.CarModelSorter;
import com.dealer.data.sorters.impl.CarNumberOfBedsSorter;
import com.dealer.data.sorters.impl.CarPriceSorter;
import com.dealer.data.sorters.impl.CarVoltageSorter;
import com.dealer.data.sorters.impl.CarYearSorter;

public class EmployeeApp {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        mainLoop(new EmployeeManager(Source.CSV));
    }

    private static void mainLoop(EmployeeManager app) {
        final int TAKE_QUIZ = 3;
        while (true) {
            System.out.println(TAKE_QUIZ + ": Take the MANDATORY employee quiz");
            printOptions();
            System.out.print("Please choose an option: ");
            try {
                int input = Util.getInput(sc);
                if (input == Options.VIEW_CARS.getCode()) viewCars(app);
                else if (input == Options.FILTER_CARS.getCode()) filterCars(app);
                else if (input == TAKE_QUIZ) app.becomeGreatSaleSperson(sc);
                else if (input == Options.QUIT.getCode()) break;
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            }
        }
    }

    private static void viewCars(EmployeeManager app) {
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
                List<Car> cars = app.cars();
                int input = Util.getInput(sc);
                if (input == NO_SORTING) {
                    Util.printCars(cars);
                    break;
                } 
                else if (input == SORT_BY_MODEL) app.carSortingStrategy(new CarModelSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_PRICE) app.carSortingStrategy(new CarPriceSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_YEAR) app.carSortingStrategy(new CarYearSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_VOLTAGE) app.carSortingStrategy(new CarVoltageSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_CHARGER_TYPE) app.carSortingStrategy(new CarChargerTypeSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_MAX_PASSENGERS) app.carSortingStrategy(new CarMaxPassengersSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_NUMBER_OF_BEDS) app.carSortingStrategy(new CarNumberOfBedsSorter(Util.askOrder(sc)));
                else throw new NumberFormatException();
                if (app.getAbstractCarSorter() instanceof CarVoltageSorter || app.getAbstractCarSorter() instanceof CarChargerTypeSorter) {
                    app.carFilteringStrategy(new TypeElectricCarFilter());
                    cars = app.filterCars(cars);
                } 
                else if (app.getAbstractCarSorter() instanceof CarMaxPassengersSorter || app.getAbstractCarSorter() instanceof CarNumberOfBedsSorter) {
                    app.carFilteringStrategy(new TypeRVFilter());
                    cars = app.filterCars(cars);
                }
                app.sortCars(cars);
                Util.printCars(cars);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            } 
        }    
    }

    private static void filterCars(EmployeeManager app) {
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
                List<Car> cars = app.cars();
                int input = Util.getInput(sc);
                if (input == FILTER_COLOR) app.carFilteringStrategy(new CarColorFilter(Util.askStringQuery(sc)));
                else if (input == FILTER_MODEL) app.carFilteringStrategy(new CarModelFilter(Util.askStringQuery(sc)));
                else if (input == FILTER_PRICE) app.carFilteringStrategy(new CarPriceFilter(Util.askFilterOperation(sc), Util.askIntQuery(sc)));
                else if (input == FILTER_VOLTAGE) app.carFilteringStrategy(new CarVoltageFilter(Util.askFilterOperation(sc), Util.askIntQuery(sc)));
                else if (input == FILTER_YEAR) app.carFilteringStrategy(new CarYearFilter(Util.askFilterOperation(sc), Util.askIntQuery(sc)));
                else if (input == FILTER_CHARGER) app.carFilteringStrategy(new ChargerTypeFilter(Util.askStringQuery(sc)));
                else if (input == FILTER_KITCHEN) app.carFilteringStrategy(new RVKitchenFilter(true));
                else if (input == FILTER_MAX_PASSENGERS) app.carFilteringStrategy(new RVMaxPassengersFilter(Util.askFilterOperation(sc), Util.askIntQuery(sc)));
                else if (input == FILTER_NUM_BEDS) app.carFilteringStrategy(new RVNumberOfBedsFilter(Util.askFilterOperation(sc), Util.askIntQuery(sc)));
                else if (input == FILTER_NUM_BEDS) app.carFilteringStrategy(new TypeRegularCarFilter());
                else if (input == FILTER_ELECTRIC) app.carFilteringStrategy(new TypeElectricCarFilter());
                else if (input == FILTER_RV) app.carFilteringStrategy(new TypeRVFilter());
                else throw new NumberFormatException();
                cars = app.filterCars(cars);
                Util.printCars(cars);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printOptions() {
        List<Options> employeeOptions = new ArrayList<Options>(Arrays.asList(
            Options.VIEW_CARS,
            Options.FILTER_CARS,
            Options.QUIT
        ));
        for (Options option : Options.values()) {
            if (employeeOptions.contains(option)) {
                System.out.println(option);
            }
        }   
    }
}
