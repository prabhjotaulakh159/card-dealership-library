package com.dealer.display;

import java.util.List;

import com.dealer.data.models.cars.Car;
import com.dealer.data.models.people.Customer;

public class Utils {
    public static void greet() {
        System.out.println("Welcome to the Dealer Management System (Admin Version) !");
    }

    public static void printOptions() {
        for (Options option : Options.values()) {
            System.out.println(option);
        }
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    } 
}
