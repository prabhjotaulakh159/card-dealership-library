package com.dealer.data;

import java.util.List;

import com.dealer.models.Appointment;
import com.dealer.models.Location;
import com.dealer.models.Sale;
import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

public interface DataReader {
    List<Car> getCars();
    List<Location> getLocations();
    List<Appointment> getAppointements();
    List<Sale> getSales();
    List<Customer> getCustomers();
    List<Employee> getEmployees();
}
