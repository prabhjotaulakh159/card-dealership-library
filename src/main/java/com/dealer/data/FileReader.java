package com.dealer.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

public class FileReader implements DataReader {
    
    public FileReader() {
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars =  new ArrayList<Car>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src\\main\\java\\com\\dealer\\resources\\cars.csv"));
            for (String line : lines) {
                String[] data = line.split(",");
                String model = data[0];
                int year = Integer.parseInt(data[1]);
                String color = data[2];
                int price = Integer.parseInt(data[3]);
                cars.add(new Car(model, year, color, price));
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
