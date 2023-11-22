package com.dealer.managers;

import java.util.InputMismatchException;
import java.util.List;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.filters.impl.CustomerNameFilter;
import com.dealer.data.filters.impl.CustomerPhoneFilter;
import com.dealer.data.filters.impl.EmployeeNameFilter;
import com.dealer.data.filters.impl.EmployeePhoneFilter;
import com.dealer.data.filters.impl.EmployeeSalaryFilter;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;
import com.dealer.data.sorters.impl.CustomerNameSorter;
import com.dealer.data.sorters.impl.EmployeeNameSorter;
import com.dealer.data.sorters.impl.EmployeeSalarySorter;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

/**
 * Manager class for admins
 * @author Prabhjot Aulakh, Safin Haque
 */
public class AdminManager extends Manager {
    private final int CUSTOMER_OPTION = 3;
    private final int CUSTOMER_FILTER_OPTION = 4;
    private final int EMPLOYEE_OPTION = 5;
    private final int EMPLOYEE_FILTER_OPTION = 6;
    private final int QUIT = 7;

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
                    throw new InputMismatchException();
                }
                this.abstractCustomerSorter.sortCustomers(customers);
                printCustomers(customers);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
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
                    throw new InputMismatchException();
                }
                customers = this.customerFilter.filterCustomers(customers);
                printCustomers(customers);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
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
                    throw new InputMismatchException();
                }
                this.abstractEmployeeSorter.sortEmployees(employees);
                printEmployees(employees);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
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
                    throw new InputMismatchException();
                }
                employees = this.employeeFilter.filterEmployees(employees);
                printEmployees(employees);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a valid option!");
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
}
