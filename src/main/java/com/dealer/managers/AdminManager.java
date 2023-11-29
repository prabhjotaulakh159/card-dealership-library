package com.dealer.managers;

import java.util.List;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.impl.CustomerNameFilter;
import com.dealer.data.filters.impl.CustomerPhoneFilter;
import com.dealer.data.filters.impl.EmployeeNameFilter;
import com.dealer.data.filters.impl.EmployeePhoneFilter;
import com.dealer.data.filters.impl.EmployeeSalaryFilter;
import com.dealer.data.loaders.FileLoader;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.impl.CustomerNameSorter;
import com.dealer.data.sorters.impl.EmployeeNameSorter;
import com.dealer.data.sorters.impl.EmployeeSalarySorter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

/**
 * Manager class for admins
 * @author Prabhjot Aulakh, Safin Haque
 */
public class AdminManager extends AbstractManager {
    private final int CUSTOMER_OPTION = 3;
    private final int CUSTOMER_FILTER_OPTION = 4;
    private final int EMPLOYEE_OPTION = 5;
    private final int EMPLOYEE_FILTER_OPTION = 6;
    private final int CREATE_CAR = 7;
    private final int UPDATE_CAR = 8;
    private final int DELETE_CAR = 9;
    private final int QUIT = 10;

    /**
     * Constructor
     * @param dataLoader Strategy for loading data from a source (file/oracle)
     */
    public AdminManager(IDataLoader dataLoader) {
        super(dataLoader);
    }
    
    /**
     * Sets the filtering strategy for customers
     * @param filter Strategy for filtering customers
     */
    public void setCustomerFilteringStrategy(ICustomerFilter filter) { 
        this.customerFilter = filter;
    }

    public void setCustomerSortingStrategy (AbstractCustomerSorter sorter) { 
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
     * Sets the filtering strategy for employees
     * @param filter Strategy for filtering employees
     */
    public void setEmployeeFilteringStrategy(IEmployeeFilter filter) { 
        this.employeeFilter = filter;
    }

    /**
     * Entry point of the manager class
     */
    @Override
    public void run() {
        System.out.println("Welcome to car inventory manager!");
        while (true) {
            System.out.println(this.CAR_OPTION + ": view cars");
            System.out.println(this.CAR_FILTER_OPTION + ": filter cars");
            System.out.println(this.CUSTOMER_OPTION + ": view customers");
            System.out.println(this.CUSTOMER_FILTER_OPTION + ": filter customers");
            System.out.println(this.EMPLOYEE_OPTION + ": view employees");
            System.out.println(this.EMPLOYEE_FILTER_OPTION + ": filter employees");
            System.out.println(this.CREATE_CAR + ": create car");
            System.out.println(this.UPDATE_CAR + ": update car");
            System.out.println(this.DELETE_CAR + ": delete car");
            System.out.println(this.QUIT + ": quit");
            System.out.print("Please choose an option from above >>> ");
            try {
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == this.CAR_OPTION) {
                    this.queryCars();
                } else if (input == this.CAR_FILTER_OPTION) {
                    this.filterCars();
                } else if (input == this.CUSTOMER_OPTION) {
                    this.queryCustomers();
                } else if (input == this.CUSTOMER_FILTER_OPTION) {
                    this.filterCustomers();
                } else if (input == this.EMPLOYEE_OPTION) {
                    this.queryEmployees();
                } else if (input == this.EMPLOYEE_FILTER_OPTION) {
                    this.filterEmployees();  
                } else if (input == this.CREATE_CAR) {
                    this.createCar();
                } else if (input == this.DELETE_CAR){
                    this.deleteCar();
                }else if (input == QUIT) {
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            } 
        }
        System.out.println("Good bye !");
    }

    /**
     * Provides UI for querying Customers by sorting
     */
    private void queryCustomers() {
        final int NO_SORTING = 1;
        final int SORT_BY_NAME = 2;
        while (true) {
            System.out.println(NO_SORTING + ": Skip sorting");
            System.out.println(SORT_BY_NAME + ": Sort by name");
            System.out.print(">>>> ");
            try {
                List<Customer> customers = this.dataLoader.getCustomers();
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == NO_SORTING) {
                    printCustomers(customers);
                    break;
                } else if (input == SORT_BY_NAME) {
                    this.setCustomerSortingStrategy(new CustomerNameSorter(this.askOrder()));
                } else {
                    throw new NumberFormatException();
                }
                this.abstractCustomerSorter.sortCustomers(customers);
                printCustomers(customers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI for filtering customers
     */
    private void filterCustomers() {
        final int FILTER_NAME = 1;
        final int FILTER_PHONE = 2;
        while (true) {
            System.out.println(FILTER_NAME + ": filter by name");
            System.out.println(FILTER_PHONE + ": filter by phone");
            System.out.print(">>>> ");
            try {
                List<Customer> customers = this.dataLoader.getCustomers();
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == FILTER_NAME) {
                    this.setCustomerFilteringStrategy(new CustomerNameFilter(this.askStringQuery()));
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

    /**
     * Provides UI to query employees and sort them
     */
    private void queryEmployees() {
        final int NO_SORTING = 1;
        final int SORT_BY_NAME = 2;
        final int SORT_BY_SALARY = 3;
        while (true) {
            System.out.println(NO_SORTING + ": Skip sorting");
            System.out.println(SORT_BY_NAME + ": Sort by name");
            System.out.println(SORT_BY_SALARY + ": Sort by salary");
            System.out.print(">>>> ");
            try {
                List<Employee> employees = this.dataLoader.getEmployees();
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == NO_SORTING) {
                    printEmployees(employees);
                    break;
                } else if (input == SORT_BY_NAME) {
                    this.setEmployeeSortingStrategy(new EmployeeNameSorter(this.askOrder()));
                } else if (input == SORT_BY_SALARY) {
                    this.setEmployeeSortingStrategy(new EmployeeSalarySorter(this.askOrder()));
                } else {
                    throw new NumberFormatException();
                }
                this.abstractEmployeeSorter.sortEmployees(employees);
                printEmployees(employees);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to filter employees
     */
    private void filterEmployees() {
        final int FILTER_NAME = 1;
        final int FILTER_PHONE = 2;
        final int FILTER_SALARY = 3;
        while (true) {
            System.out.println(FILTER_NAME + ": filter by name");
            System.out.println(FILTER_PHONE + ": filter by phone");
            System.out.println(FILTER_SALARY + ": filter by salary");
            System.out.print(">>>> ");
            try {
                List<Employee> employees = this.dataLoader.getEmployees();
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == FILTER_NAME) {
                    this.setEmployeeFilteringStrategy(new EmployeeNameFilter(this.askStringQuery()));
                } else if (input == FILTER_PHONE) {
                    this.setEmployeeFilteringStrategy(new EmployeePhoneFilter(this.askStringQuery()));
                } else if (input == FILTER_SALARY) {
                    this.setEmployeeFilteringStrategy(new EmployeeSalaryFilter(this.askFilterOperation(), this.askIntQuery()));
                } else {
                    throw new NumberFormatException();
                }
                employees = this.employeeFilter.filterEmployees(employees);
                printEmployees(employees);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides UI to create a car
     */
    private void createCar() {
        final int CREATE_CAR = 1;
        final int CREATE_ELECTRIC = 2;
        final int CREATE_RV = 3;
        while (true) {
            System.out.println(CREATE_CAR + ": Create regular car");
            System.out.println(CREATE_ELECTRIC + ": Create electric car");
            System.out.println(CREATE_RV + ": Create recreational vehicle");
            System.out.println(this.QUIT + ": Cancel creation");
            System.out.print(">>>> ");
            Car car = null;
            try {
                int input = Integer.parseInt(this.scanner.nextLine());
                if (input == CREATE_CAR) {
                    car = new Car (
                        this.askString("model"), 
                        this.askInt("year"), 
                        this.askString("color"), 
                        this.askInt("price")
                    );
                } else if (input == CREATE_ELECTRIC) {
                    car = new ElectricCar (
                        this.askString("model"), 
                        this.askInt("year"), 
                        this.askString("color"), 
                        this.askInt("price"),
                        this.askInt("voltage"),
                        this.askString("charger type")
                    );
                } else if (input == CREATE_RV) {
                    car = new RecreationalVehicle(
                        this.askString("model"), 
                        this.askInt("year"), 
                        this.askString("color"),                 
                        this.askInt("price"),
                        this.askInt("max passengers"),
                        this.askInt("number of beds"),
                        this.askForKitchen());
                } else if (input == QUIT) {
                    break;  
                } else {
                    throw new NumberFormatException();
                }
                this.carUpdater.create(car);
                System.out.println("New entry added !");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Data: " + e.getMessage());
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteCar(){
        final int QUIT_PAGE =0;
        while (true){
            System.out.println("Choose the Index of the car you want to delete");
            System.out.println(QUIT_PAGE + ": If you want to Cancel Deletion");
            try{
                int counter = 1;
                List<Car> cars = this.dataLoader.getCars();
                for(Car car : cars){
                    System.out.println("(ID: " + (counter++) + ")  " + car);
                }
                int input = Integer.parseInt(this.scanner.nextLine());
                if(input == QUIT_PAGE){
                    break;
                }
                if(input < 0 || input> cars.size()){
                    throw new NumberFormatException();
                }
                if(this.dataLoader instanceof FileLoader){
                    this.carUpdater.delete(input-1);
                }else if(this.dataLoader instanceof OracleLoader){
                    this.carUpdater.delete(input);
                }
                System.out.println("Car deleted!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Data: " + e.getMessage());
            } catch (LoaderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Prints a list of customers on the terminal
     * @param customers List of customers to be printed
     */
    private void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }   

    /**
     * Prints a list of employees on the terminal
     * @param employees List of employees to be printed
     */
    private void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * Provides UI to ask about string-related car properties
     * @param whatToAskFor String about the property we want to ask for
     * @return Car model entered by user
     */
    private String askString(String whatToAskFor) {
        System.out.println("Please enter " + whatToAskFor + ": ");
        return this.scanner.nextLine();
    }

    /**
     * Provides UI to ask a car model
     * @param whatToAskFor String about the property we want to ask for
     * @return Car model entered by user
     */
    private int askInt(String whatToAskFor) {
        while (true) {
            try {
                System.out.println("Please enter " + whatToAskFor + ": ");
                return Integer.parseInt(this.scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option");
            }
        }
    }

    /**
     * Provides UI to ask if a recreational vehicle has a kitchen
     * @return true or false
     */
    private boolean askForKitchen() {
        final int YES = 1;
        final int NO = 2;
        while (true) {
            System.out.println("Enter " + YES + " if it has a kitchen");
            System.out.println("Enter " + NO + " if it does not have a kitchen");
            try {
                int input = Integer.parseInt(this.scanner.nextLine());
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
}
