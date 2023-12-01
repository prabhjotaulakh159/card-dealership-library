package com.dealer.display;

import java.util.List;
import java.util.Scanner;

import com.dealer.DatabaseCredentials;
import com.dealer.business.AdminManager;
import com.dealer.data.Source;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.impl.CarColorFilter;
import com.dealer.data.filters.impl.CarModelFilter;
import com.dealer.data.filters.impl.CarPriceFilter;
import com.dealer.data.filters.impl.CarVoltageFilter;
import com.dealer.data.filters.impl.CarYearFilter;
import com.dealer.data.filters.impl.ChargerTypeFilter;
import com.dealer.data.filters.impl.CustomerNameFilter;
import com.dealer.data.filters.impl.CustomerPhoneFilter;
import com.dealer.data.filters.impl.EmployeeNameFilter;
import com.dealer.data.filters.impl.EmployeePhoneFilter;
import com.dealer.data.filters.impl.EmployeeSalaryFilter;
import com.dealer.data.filters.impl.RVKitchenFilter;
import com.dealer.data.filters.impl.RVMaxPassengersFilter;
import com.dealer.data.filters.impl.RVNumberOfBedsFilter;
import com.dealer.data.filters.impl.TypeElectricCarFilter;
import com.dealer.data.filters.impl.TypeRVFilter;
import com.dealer.data.filters.impl.TypeRegularCarFilter;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;
import com.dealer.data.models.people.Customer;
import com.dealer.data.models.people.Employee;
import com.dealer.data.sorters.impl.CarChargerTypeSorter;
import com.dealer.data.sorters.impl.CarMaxPassengersSorter;
import com.dealer.data.sorters.impl.CarModelSorter;
import com.dealer.data.sorters.impl.CarNumberOfBedsSorter;
import com.dealer.data.sorters.impl.CarPriceSorter;
import com.dealer.data.sorters.impl.CarVoltageSorter;
import com.dealer.data.sorters.impl.CarYearSorter;
import com.dealer.data.sorters.impl.CustomerNameSorter;
import com.dealer.data.sorters.impl.EmployeeNameSorter;
import com.dealer.data.sorters.impl.EmployeeSalarySorter;

/**
 * Admin version of the application
 * @author Prabhjot Aulakh, Safin Haque
 */
public class AdminApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Source source = Source.ORACLE;
        if (source == Source.ORACLE) {
            if (    DatabaseCredentials.USERNAME.isEmpty() ||
            DatabaseCredentials.PASSWORD.isEmpty() ||
            DatabaseCredentials.USERNAME.isBlank() ||
            DatabaseCredentials.PASSWORD.isBlank() ||
            DatabaseCredentials.USERNAME == null   ||
            DatabaseCredentials.PASSWORD == null) {
                System.out.println("You have attempted to connect to a database, but empty/invalid credentials were provided");
                System.out.println("Please ensure that your credentials in DatabaseCredentials.java are correct");
                System.out.println("NOTE: Please ensure to run the script.sql file in resources before running the app");
                System.out.println("If you wish to not connect to a database, simply change the source within the first line of the main method");
                System.exit(0);
            }            
        }
        AdminManager app = new AdminManager(source);
        mainLoop(app);
    }

    /**
     * Main loop of the app, providing different options for admins
     * @param app Manager/business layer for the application
     */
    private static void mainLoop(AdminManager app) {
        while (true) {
            printOptions();
            System.out.print("Please choose an option: ");
            try {
                int input = Util.getInput(sc);
                if (input == Options.VIEW_CARS.getCode()) viewCars(app);
                else if (input == Options.FILTER_CARS.getCode()) filterCars(app);
                else if (input == Options.VIEW_CUSTOMERS.getCode()) viewCustomers(app);
                else if (input == Options.FILTER_CUSTOMERS.getCode()) filterCustomers(app);
                else if (input == Options.VIEW_EMPLOYEES.getCode()) viewEmployees(app);
                else if (input == Options.FILTER_EMPLOYEES.getCode()) filterEmployees(app);
                else if (input == Options.CREATE_CAR.getCode()) createCar(app);
                else if (input == Options.UPDATE_CAR.getCode()) updateCar(app);
                else if (input == Options.DELETE_CAR.getCode()) deleteCar(app);
                else if (input == Options.QUIT.getCode()) break;
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            }
        }
        app.killResources();
    }

    /**
     * Provides UI to view cars 
     * @param app Manager/business layer for the application
     */
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

    /**
     * Provides UI to filter cars 
     * @param app Manager/business layer for the application
     */
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

    /**
     * Provides UI to view customers 
     * @param app Manager/business layer for the application
     */
    private static void viewCustomers(AdminManager app) {
        final int NO_SORTING = 1;
        final int SORT_BY_NAME = 2;
        while (true) {
            System.out.println(NO_SORTING + ": Skip sorting");
            System.out.println(SORT_BY_NAME + ": Sort by name");
            System.out.print(">>>> ");
            try {
                List<Customer> customers = app.customers();
                int input = Util.getInput(sc);
                if (input == NO_SORTING) {
                    printCustomers(customers);
                    break;
                } 
                else if (input == SORT_BY_NAME) app.customerSortingStrategy(new CustomerNameSorter(Util.askOrder(sc)));
                else throw new NumberFormatException();
                app.sortCustomers(customers);
                printCustomers(customers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to filter customers
     * @param app Manager/business layer for the application
     */
    private static void filterCustomers(AdminManager app) {
        final int FILTER_NAME = 1;
        final int FILTER_PHONE = 2;
        while (true) {
            System.out.println(FILTER_NAME + ": filter by name");
            System.out.println(FILTER_PHONE + ": filter by phone");
            System.out.print(">>>> ");
            try {
                List<Customer> customers = app.customers();
                int input = Util.getInput(sc);
                if (input == FILTER_NAME) app.customerFilteringStrategy(new CustomerNameFilter(Util.askStringQuery(sc)));
                else if (input == FILTER_PHONE) app.customerFilteringStrategy(new CustomerPhoneFilter(Util.askStringQuery(sc)));
                else throw new NumberFormatException();
                customers = app.filterCustomers(customers);
                printCustomers(customers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to view employees
     * @param app Manager/business layer for the application
     */
    private static void viewEmployees(AdminManager app) {
        final int NO_SORTING = 1;
        final int SORT_BY_NAME = 2;
        final int SORT_BY_SALARY = 3;
        while (true) {
            System.out.println(NO_SORTING + ": Skip sorting");
            System.out.println(SORT_BY_NAME + ": Sort by name");
            System.out.println(SORT_BY_SALARY + ": Sort by salary");
            System.out.print(">>>> ");
            try {
                List<Employee> employees = app.employees();
                int input = Util.getInput(sc);
                if (input == NO_SORTING) {
                    printEmployees(employees);
                    break;
                }
                else if (input == SORT_BY_NAME) app.employeeSortingStrategy(new EmployeeNameSorter(Util.askOrder(sc)));
                else if (input == SORT_BY_SALARY) app.employeeSortingStrategy(new EmployeeSalarySorter(Util.askOrder(sc)));
                else throw new NumberFormatException();
                app.sortEmployees(employees);
                printEmployees(employees);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to filter employees
     * @param app Manager/business layer for the application
     */
    private static void filterEmployees(AdminManager app) {
        final int FILTER_NAME = 1;
        final int FILTER_PHONE = 2;
        final int FILTER_SALARY = 3;
        while (true) {
            System.out.println(FILTER_NAME + ": filter by name");
            System.out.println(FILTER_PHONE + ": filter by phone");
            System.out.println(FILTER_SALARY + ": filter by salary");
            System.out.print(">>>> ");
            try {
                List<Employee> employees = app.employees();
                int input = Util.getInput(sc);
                if (input == FILTER_NAME) app.employeeFilteringStrategy(new EmployeeNameFilter(Util.askStringQuery(sc)));
                else if (input == FILTER_PHONE) app.employeeFilteringStrategy(new EmployeePhoneFilter(Util.askStringQuery(sc)));
                else if (input == FILTER_SALARY) app.employeeFilteringStrategy(new EmployeeSalaryFilter(Util.askFilterOperation(sc), Util.askIntQuery(sc)));
                else throw new NumberFormatException();
                employees = app.filterEmployees(employees);
                printEmployees(employees);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Number !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to create a car
     * @param app Manager/business layer for the application
     */
    private static void createCar(AdminManager app) {
        final int CREATE_REGULAR_CAR = 1;
        final int CREATE_ELECTRIC = 2;
        final int CREATE_RV = 3;
        final int QUIT = 4;
        while (true) {
            System.out.println(CREATE_REGULAR_CAR + ": Create regular car");
            System.out.println(CREATE_ELECTRIC + ": Create electric car");
            System.out.println(CREATE_RV + ": Create recreational vehicle");
            System.out.println(QUIT + ": Cancel creation");
            System.out.print(">>>> ");
            Car car = null;
            try {
                int input = Util.getInput(sc);
                if (input == CREATE_REGULAR_CAR) car = new Car (askString("model"), askInt("year"), askString("color"), askInt("price"));
                else if (input == CREATE_ELECTRIC) car = new ElectricCar (askString("model"), askInt("year"), askString("color"), askInt("price"),askInt("voltage"),askString("charger type"));
                else if (input == CREATE_RV) car = new RecreationalVehicle(askString("model"), askInt("year"), askString("color"), askInt("price"), askInt("max passengers"), askInt("number of beds"), askForKitchen());
                else if (input == QUIT) break;  
                else throw new NumberFormatException();
                app.createCar(car);
                System.out.println("New entry added !");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Number !");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Data: " + e.getMessage());
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to update a car
     * @param app Manager/business layer for the application
     */
    private static void updateCar(AdminManager app) {
        final int QUIT = 0;
        while (true) {
            System.out.println(QUIT + ": Exit update");
            System.out.println("Enter index to update: ");
            Car car = null;
            try {
                int counter = 1;
                List<Car> cars = app.cars();
                for (Car c : cars) {
                    System.out.println("(ID: " + (counter++) + ")  " + c);
                }
                int input = Util.getInput(sc);
                if (input == QUIT) break;
                if (input < 0 || input > cars.size()) throw new NumberFormatException();
                if (cars.get(input - 1) instanceof ElectricCar) car = new ElectricCar (askString("model"), askInt("year"), askString("color"), askInt("price"), askInt("voltage"), askString("charger type"));
                else if (cars.get(input - 1) instanceof RecreationalVehicle) car = new RecreationalVehicle(askString("model"), askInt("year"), askString("color"), askInt("price"), askInt("max passengers"), askInt("number of beds"), askForKitchen());
                else car = new Car (askString("model"), askInt("year"), askString("color"), askInt("price"));
                app.updateCar(car, input);
                System.out.println("Entry updated!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Number !");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Data: " + e.getMessage());
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to delete a car
     * @param app Manager/business layer for the application
     */
    private static void deleteCar(AdminManager app){
        final int QUIT_PAGE = 0;
        while (true){
            System.out.println("Choose the Index of the car you want to delete");
            System.out.println(QUIT_PAGE + ": If you want to Cancel Deletion");
            try{
                int counter = 1;
                List<Car> cars = app.cars();
                for(Car car : cars){
                    System.out.println("(ID: " + (counter++) + ")  " + car);
                }
                int input = Util.getInput(sc);
                if(input == QUIT_PAGE) break;
                if(input < 0 || input> cars.size())throw new NumberFormatException();
                app.deleteCar(input);
                System.out.println("Entry deleted!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Number !");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Data: " + e.getMessage());
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Greets the user to the Dealer Management System
     */
    public static void greet() {
        System.out.println("Welcome to the Dealer Management System (Admin Version) !");
    }

    /**
     * Prints out all the available options for admin 
     */
    public static void printOptions() {
        for (Options option : Options.values()) {
            System.out.println(option);
        }
    }
    
    /**
     * Provides UI to ask about string-related car properties
     * @param whatToAskFor String about the property we want to ask for
     * @param sc Scanner object to get user input
     * @return User input entered by user
     */
    public static String askString(String whatToAskFor) {
        System.out.println("Please enter " + whatToAskFor + ": ");
        return sc.nextLine();
    }

    /**
     * Provides UI to ask a car model
     * @param whatToAskFor String about the property we want to ask for
     * @param sc Scanner object to get user input
     * @return User input entered by user
     */
    public static int askInt(String whatToAskFor) throws NumberFormatException {
        while (true) {
            try {
                System.out.println("Please enter " + whatToAskFor + ": ");
                return Util.getInput(sc);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option");
            }
        }
    }

    /**
     * Provides UI to ask if a recreational vehicle has a kitchen
     * @param sc Scanner object to get user input
     * @return true or false if the recreational vehicle has a kitchen
     */
    private static boolean askForKitchen() throws NumberFormatException {
        final int YES = 1;
        final int NO = 2;
        while (true) {
            System.out.println("Enter " + YES + " if it has a kitchen");
            System.out.println("Enter " + NO + " if it does not have a kitchen");
            try {
                int input = Util.getInput(sc);
                if (input == YES) {
                    return true;
                } else if (input == NO) {
                    return false;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option");
            }
        }
    }

    /**
     * Prints a list of customers
     * @param customers List of customers
     */
    public static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * Prints a list of employees 
     * @param employees List of employees
     */
    public static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    } 
}
