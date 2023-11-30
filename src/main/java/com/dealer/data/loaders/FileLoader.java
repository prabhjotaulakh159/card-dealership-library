package com.dealer.data.loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealer.data.Constants;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;
import com.dealer.data.models.people.Customer;
import com.dealer.data.models.people.Employee;

/**
 * Fetches data from CSV files and stores them in lists
 * @author Prabhjot Aulakh, Safin Haque
 */
public class FileLoader implements IDataLoader {
    /**
     * Retrives the list of cars in source
     * @return All the cars in source
     * @throws LoaderException
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     * @throws NumberFormatException If parsing strings into integers fails
     */
    @Override
    public List<Car> getCars() throws LoaderException {
        try {
            Path path = Paths.get(Constants.CARS_CSV);
            List<String> lines = Files.readAllLines(path);
            List<Car> cars = new ArrayList<Car>();
            for (String line : lines) {
                Car placeholder = null;
                String[] data = line.split(Constants.CSV_DELIMETER);
                String typeOfCar = data[0];
                String model = data[1];
                int year = Integer.parseInt(data[2]);
                String color = data[3];
                int price = Integer.parseInt(data[4]);
                if (typeOfCar.equals(Constants.CAR_TYPE)) {
                    placeholder = new Car(model, year, color, price);
                } else if (typeOfCar.equals(Constants.ELECTRIC_TYPE)) {
                    int voltage = Integer.parseInt(data[5]);
                    String chargerType = data[6];
                    placeholder = new ElectricCar(model, year, color, price, voltage, chargerType);
                } else if (typeOfCar.equals(Constants.RV_TYPE)) {
                    int maxPassengers = Integer.parseInt(data[5]);
                    int numberOfBeds = Integer.parseInt(data[6]);
                    boolean hasKitchen = Boolean.parseBoolean(data[7]);
                    placeholder = new RecreationalVehicle(model, year, color, price, maxPassengers, numberOfBeds, hasKitchen);
                }
                cars.add(placeholder);
            }
            return cars;
        } 
        catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    /**
     * Retrives the list of customer in source
     * @return All the customers in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    @Override
    public List<Customer> getCustomers() throws LoaderException {
        try {
            Path path = Paths.get(Constants.CUSTOMERS_CSV);
            List<String> lines = Files.readAllLines(path);
            List<Customer> customers = new ArrayList<Customer>();
            for (String line : lines) {
                String[] data = line.split(Constants.CSV_DELIMETER);
                String name = data[0];
                String phoneNumber = data[1];
                customers.add(new Customer(name, phoneNumber));
            }
            return customers;
        }
        catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    /**
     * Retrives the list of employees in source
     * @return All the employees in source
     * @throws LoaderException
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    @Override
    public List<Employee> getEmployees() throws LoaderException {
        try {
            Path path = Paths.get(Constants.EMPLOYEES_CSV);
            List<String> lines = Files.readAllLines(path);
            List<Employee> employees = new ArrayList<Employee>();
            for (String line : lines) {
                String[] data = line.split(Constants.CSV_DELIMETER);
                String name = data[0];
                String phoneNumber = data[1];
                int salary = Integer.parseInt(data[2]);
                employees.add(new Employee(name, phoneNumber, salary));
            }
            return employees;
        }
        catch (IOException e) {
            throw new LoaderException(e);
        }
    }
}
