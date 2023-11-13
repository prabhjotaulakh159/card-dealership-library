package com.dealer.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.dealer.models.Types;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

public class FileReader implements DataReader {
    @Override
    public List<Car> getCars() {
        List<Car> cars =  new ArrayList<Car>();
        Car placeholder = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get("src\\main\\java\\com\\dealer\\resources\\cars.csv"));
            for (String line : lines) {
                String[] data = line.split(",");
                String type = data[0];
                System.out.println(type);
                if (type.equals(Types.CAR.getType())) 
                    placeholder = new Car(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                else if (type.equals(Types.ELECTRIC.getType()))
                    placeholder = new ElectricCar(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6]);
                else if (type.equals(Types.RV.getType()))
                    placeholder = new RecreationalVehicle(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Boolean.parseBoolean(data[7]));
                cars.add(placeholder);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }
    
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src\\main\\java\\com\\dealer\\resources\\customers.csv"));
            for (String line : lines) {
                String[] data = line.split(",");
                String name = data[0];
                String phone = data[1];
                customers.add(new Customer(name, phone));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src\\main\\java\\com\\dealer\\resources\\employees.csv"));
            for (String line: lines) {
                String[] data = line.split(",");
                String name = data[0];
                String phone = data[1];
                int salary = Integer.parseInt(data[2]);
                employees.add(new Employee(name, phone, salary));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }
}
