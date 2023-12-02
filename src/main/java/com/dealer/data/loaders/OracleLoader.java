package com.dealer.data.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealer.data.Constants;
import com.dealer.data.Mode;
import com.dealer.data.OracleConnector;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;
import com.dealer.data.models.people.Customer;
import com.dealer.data.models.people.Employee;

/**
 * Fetches data from an oracle database
 * @author Prabhjot Aulakh, Safin Haque
 */
public class OracleLoader extends OracleConnector implements IDataLoader {
    /**
     * Retrives cars from the database and turns it into a list
     * @param mode determines if dataLoading is running in test or production
     * @return List of cars from the database
     * @throws LoaderException If an SQLException occurs
     */
    @Override
    public List<Car> getCars(Mode mode) throws LoaderException {
        try {
            List<Car> cars = new ArrayList<Car>();
            String SQL = mode == Mode.PRODUCTION ? "SELECT * FROM car ORDER BY id ASC" : "SELECT * FROM car_test ORDER BY id ASC";
            PreparedStatement statement = this.getConnection().prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Car placeholder = null;
                String type = result.getString(2);
                String model = result.getString(3);
                int year = result.getInt(4);
                String color = result.getString(5);
                int price = result.getInt(6);
                int voltage = result.getInt(7);
                String charger = result.getString(8);
                int maxPassengers = result.getInt(9);
                int numberOfBeds = result.getInt(10);
                boolean kitchen = result.getInt(11) == 1 ? true : false;
                if (type.equals(Constants.CAR_TYPE)) {
                    placeholder = new Car(model, year, color, price);
                } else if (type.equals(Constants.ELECTRIC_TYPE)) {
                    placeholder = new ElectricCar(model, year, color, price, voltage, charger);
                } else if (type.equals(Constants.RV_TYPE)) {
                    placeholder = new RecreationalVehicle(model, year, color, price, maxPassengers, numberOfBeds, kitchen);
                }
                cars.add(placeholder);
            }
            return cars;
        } catch (SQLException e) {
            throw new LoaderException(e);
        } 
    }

    /**
     * Retrives customers from the database and turns it into a list
     * @param mode determines if dataLoading is running in test or production
     * @return List of customers from the database
     * @throws LoaderException If an SQLException occurs
     */
    @Override
    public List<Customer> getCustomers(Mode mode) throws LoaderException {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            String SQL = mode == Mode.PRODUCTION ? "SELECT * FROM customer" : "SELECT * FROM customer_test";
            PreparedStatement statement = this.getConnection().prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString(1);
                String phone = result.getString(2);
                customers.add(new Customer(name, phone));
            }
            return customers;
        } catch (SQLException e) {
            throw new LoaderException(e);
        } 
    }

    /**
     * Retrives employees from the database and turns it into a list
     * @param mode determines if dataLoading is running in test or production
     * @return List of employees from the database
     * @throws LoaderException If an SQLException occurs
     */
    @Override
    public List<Employee> getEmployees(Mode mode) throws LoaderException {
        try {
            List<Employee> employees = new ArrayList<Employee>();
            String SQL = mode == Mode.PRODUCTION ? "SELECT * FROM employee" : "SELECT * FROM employee_test";
            PreparedStatement statement = this.getConnection().prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString(1);
                String phone = result.getString(2);
                int salary = result.getInt(3);
                employees.add(new Employee(name, phone, salary));
            }
            return employees;
        } catch (SQLException e) {
            throw new LoaderException(e);
        } 
    }   
}
