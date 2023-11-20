package com.dealer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.Order;
import com.dealer.data.sorters.impl.CarModelSorter;
import com.dealer.data.sorters.impl.CarPriceSorter;
import com.dealer.data.sorters.impl.CarYearSorter;
import com.dealer.data.sorters.impl.CustomerNameSorter;
import com.dealer.data.sorters.impl.EmployeeNameSorter;
import com.dealer.data.sorters.impl.EmployeeSalarySorter;
import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

public class Manager {
    private final int VIEW_CARS_OPTION = 1;
    private final int VIEW_EMPLOYEES_OPTION = 2;
    private final int VIEW_CUSTOMERS_OPTION = 3;
    private final int DO_NOT_SORT = 4;
    private final int SORT_CAR_BY_PRICE = 5;
    private final int SORT_CAR_BY_MODEL = 6;
    private final int SORT_CAR_BY_YEAR = 7;
    private final int ASCENDING = 8;
    private final int DESCENDING = 9;
    private final int SORT_BY_NAME = 10;
    private final int SORT_BY_SALARY = 11;

    private Scanner sc;
    private IDataLoader loader;
    
    public Manager(IDataLoader loader) {
        this.sc = new Scanner(System.in);
        this.loader = loader;
    }

    public void runApp() {
        System.out.println("Welcome to car management system !");
        System.out.println("Please enter an a number to choose your next option");
        while (true) {
            this.displayOptions();
            int option = chooseOption();
            if (option == VIEW_CARS_OPTION) {
                this.displayCars();
            } else if (option == VIEW_EMPLOYEES_OPTION) {
                this.displayEmployees();
            } else if (option ==  VIEW_CUSTOMERS_OPTION) {
                this.displayCustomers();
            }
        }
    }

    private void displayOptions() {
        System.out.println(VIEW_CARS_OPTION + ": View cars");
        System.out.println(VIEW_EMPLOYEES_OPTION + ": View employees");
        System.out.println(VIEW_CUSTOMERS_OPTION + ": View customers");
    }

    private int chooseOption() {
        while (true) {
            try {
                System.out.print("Option >>> ");
                int option = this.sc.nextInt();
                if (option != VIEW_CARS_OPTION && option != VIEW_EMPLOYEES_OPTION && option != VIEW_CUSTOMERS_OPTION) {
                    System.out.println("You did not enter a valid option !");
                } else {
                    return option;
                }
            } catch (InputMismatchException e) { 
                System.out.println("Please enter valid input");
                this.sc.next();
            }
        }
    }

    private void displayCars() {
        while (true) {
            try {
                List<Car> carList = this.loader.getCars();
                System.out.println("Choose a sorting option: ");
                System.out.println(DO_NOT_SORT + ": Skip sorting");
                System.out.println(SORT_CAR_BY_PRICE + ": Sort by price");
                System.out.println(SORT_CAR_BY_MODEL + ": Sort by model");
                System.out.println(SORT_CAR_BY_YEAR + ": Sort by year");
                int option = this.sc.nextInt();
                if (    option != DO_NOT_SORT && 
                        option != SORT_CAR_BY_PRICE && 
                        option != SORT_CAR_BY_MODEL && 
                        option != SORT_CAR_BY_YEAR) {
                    System.out.println("Not a valid option");
                } else if (option == DO_NOT_SORT) {
                    printCars(carList);
                    break;
                }
                Order order = askOrder();
                AbstractCarSorter sorter = null;
                if (option == SORT_CAR_BY_PRICE) {
                    sorter = new CarPriceSorter(order);
                } else if (option == SORT_CAR_BY_MODEL) {
                    sorter = new CarModelSorter(order);
                } else if (option == SORT_CAR_BY_YEAR) {
                    sorter = new CarYearSorter(order);
                } else {
                    throw new IllegalArgumentException("Not a valid sorter");
                }
                sorter.sortCars(carList);
                printCars(carList);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    private void printCars(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car);
        }
    }

    private void printEmployees(List<Employee> employees) {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    private void printCustomers(List<Customer> customers) {
        for (Customer customer: customers) {
            System.out.println(customer);
        }
    }

    private Order askOrder() {
        while (true) {
            try {
                System.out.println("Enter order for sorting");
                System.out.println(ASCENDING + ": Ascending order");
                System.out.println(DESCENDING + ": Descending order");
                int order = this.sc.nextInt();
                if (order != ASCENDING && order != DESCENDING) {
                    System.out.println("Not a valid option");
                } else if (order == ASCENDING) {
                    return Order.ASCENDING;
                } else {
                    return Order.DESCENDING;
                }
            } catch (InputMismatchException e) {
                System.out.println("You did not enter a valid value");
                this.sc.next();
            }
        }
    }

    private void displayEmployees() {
        while (true) {
            try {
                List<Employee> employees = this.loader.getEmployees();
                System.out.println("Enter sorting option");
                System.out.println(this.DO_NOT_SORT + ": Skip sorting");
                System.out.println(this.SORT_BY_NAME + ": Sort by name");
                System.out.println(this.SORT_BY_SALARY + ": Sort by salary");
                int option = this.sc.nextInt();
                if (option != DO_NOT_SORT && option != SORT_BY_SALARY && option != SORT_BY_NAME) {
                    System.out.println("Please enter a valid option");
                } else if (option == DO_NOT_SORT) {
                    this.printEmployees(employees);   
                }
                Order order = this.askOrder();
                AbstractEmployeeSorter sorter = null;
                if (option == SORT_BY_NAME) {
                    sorter = new EmployeeNameSorter(order);
                } else if (option == SORT_BY_SALARY) {
                    sorter = new EmployeeSalarySorter(order);
                }
                sorter.sortEmployees(employees);
                this.printEmployees(employees);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                this.sc.next();
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayCustomers() {
        while (true) {
            try {
                List<Customer> customers = this.loader.getCustomers();
                System.out.println("Enter sorting option");
                System.out.println(this.DO_NOT_SORT + ": Skip sorting");
                System.out.println(this.SORT_BY_NAME + ": Sort by name");
                int option = this.sc.nextInt();
                if (option != DO_NOT_SORT && option!= SORT_BY_NAME) {
                    System.out.println("Please enter a valid option");
                } else if (option == DO_NOT_SORT) {
                    this.printCustomers(customers);   
                    break;
                } else {
                    Order order = this.askOrder();
                    AbstractCustomerSorter sorter = new CustomerNameSorter(order);
                    sorter.sortCustomers(customers);
                    this.printCustomers(customers);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid input");
                this.sc.next();
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }
}
