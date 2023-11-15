package com.dealer.data.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealer.data.DataConstants;
import com.dealer.data.IDataLoader;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

/**
 * Fetches data from CSV files and stores them in lists
 * @author Prabhjot Aulakh, Safin Haque
 */
public class FileLoader implements IDataLoader {
    /**
     * Retrives the list of cars in source
     * @return All the cars in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     * @throws NumberFormatException If parsing strings into integers fails
     */
    @Override
    public List<Car> getCars() throws IOException, SQLException, NumberFormatException {
        Path path = Paths.get(DataConstants.CARS_CSV);
        List<String> lines = Files.readAllLines(path);
        List<Car> cars = new ArrayList<Car>();
        for (String line : lines) {
            Car placeholder = null;
            String[] data = line.split(DataConstants.CSV_DELIMETER);
            String typeOfCar = data[0];
            String model = data[1];
            int year = Integer.parseInt(data[2]);
            String color = data[3];
            int price = Integer.parseInt(data[4]);
            if (typeOfCar.equals(DataConstants.CAR_TYPE)) {
                placeholder = new Car(model, year, color, price);
            } 
            else if (typeOfCar.equals(DataConstants.ELECTRIC_TYPE)) {
                int voltage = Integer.parseInt(data[5]);
                String chargerType = data[6];
                placeholder = new ElectricCar(model, year, color, price, voltage, chargerType);
            } 
            else if (typeOfCar.equals(DataConstants.RV_TYPE)) {
                int maxPassengers = Integer.parseInt(data[5]);
                int numberOfBeds = Integer.parseInt(data[6]);
                boolean hasKitchen = Boolean.parseBoolean(data[7]);
                placeholder = new RecreationalVehicle(model, year, color, price, maxPassengers, numberOfBeds, hasKitchen);
            }
            cars.add(placeholder);
        }
        return cars;
    }

    /**
     * Retrives the list of customer in source
     * @return All the customers in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     */
    @Override
    public List<Customer> getCustomers() throws IOException, SQLException {
        Path path = Paths.get(DataConstants.CUSTOMERS_CSV);
        List<String> lines = Files.readAllLines(path);
        List<Customer> customers = new ArrayList<Customer>();
        for (String line : lines) {
            String[] data = line.split(DataConstants.CSV_DELIMETER);
            String name = data[0];
            String phoneNumber = data[1];
            customers.add(new Customer(name, phoneNumber));
        }
        return customers;
    }

    /**
     * Retrives the list of employees in source
     * @return All the employees in source
     * @throws IOException If loading data from files fails
     * @throws SQLException If loading data from database fails
     * @throws NumberFormatException If parsing strings into integers fails
     */
    @Override
    public List<Employee> getEmployees() throws IOException, SQLException, NumberFormatException {
        Path path = Paths.get(DataConstants.EMPLOYEES_CSV);
        List<String> lines = Files.readAllLines(path);
        List<Employee> employees = new ArrayList<Employee>();
        for (String line : lines) {
            String[] data = line.split(DataConstants.CSV_DELIMETER);
            String name = data[0];
            String phoneNumber = data[1];
            int salary = Integer.parseInt(data[3]);
            employees.add(new Employee(name, phoneNumber, salary));
        }
        return employees;
    }
}
