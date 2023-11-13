package com.dealer.data;

import java.util.List;

import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

public interface DataReader {
    List<Car> getCars();
    List<Customer> getCustomers();
    List<Employee> getEmployees();
}
