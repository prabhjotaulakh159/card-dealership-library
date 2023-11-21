package com.dealer;

import java.util.Scanner;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ICustomerFilter;
import com.dealer.data.filters.IEmployeeFilter;
import com.dealer.data.loaders.IDataLoader;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.AbstractCustomerSorter;
import com.dealer.data.sorters.AbstractEmployeeSorter;

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
    private final int CUSTOMER_OPTION = 2;
    private final int EMPLOYEE_OPTION = 3;

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
        System.out.println("Please choose an option from below: ");
        System.out.println(this.CAR_OPTION + ": view  cars");
        System.out.println(this.CUSTOMER_OPTION + ": view customers");
        System.out.println(this.EMPLOYEE_OPTION + ": view employees");
    }
}
