package com.dealer.data;

import java.util.List;

import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

public class BulkDisplayer implements DataDisplayer {
    private DataReader reader;

    public BulkDisplayer(DataReader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("Reader cannot be null");
        }
        this.reader = reader;
    }

    @Override
    public void displayCars() {
        List<Car> cars = this.reader.getCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void displayLocations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayLocations'");
    }

    @Override
    public void displayPromotions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayPromotions'");
    }

    @Override
    public void displayAppointments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayAppointments'");
    }

    @Override
    public void displaySales() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displaySales'");
    }

    @Override
    public void displayCustomers() {
        List<Customer> customers = this.reader.getCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void displayEmployees() {
        List<Employee> employees = this.reader.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    
}
