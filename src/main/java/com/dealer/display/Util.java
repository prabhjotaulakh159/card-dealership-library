package com.dealer.display;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealer.data.filters.ListFilter;
import com.dealer.data.models.cars.Car;
import com.dealer.data.sorters.Order;

/**
 * Group of utility methods common for both admin and employee
 * @author Prabhjot Aulakh, Safin Haque
 */
public class Util {
    /**
     * Simply makes the user enter a number
     * @param sc Scanner object to get user input
     * @return user input
     * @throws NumberFormatException if the number is invalid
     */
    public static int getInput(Scanner sc) throws NumberFormatException {
        return Integer.parseInt(sc.nextLine());
    }
    
    /**
     * Prints cars on the terminal
     * @param cars List of cats to print
     */
    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    /**
     * Asks the user to choose an order for sorting
     * @param sc Scanner object to get user input
     * @return Order chosen by the user
     */
    public static Order askOrder(Scanner sc) {
        final int ASCENDING = 1;
        final int DESCENDING = 2;
        while (true) {
            try {
                System.out.println(ASCENDING + " for ascending order");
                System.out.println(DESCENDING + " for descending order");
                System.out.print(">>>> ");
                int input = Util.getInput(sc);
                if (input == ASCENDING) return Order.ASCENDING;
                else if (input == DESCENDING) return Order.DESCENDING;
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number !");
            }  
        }
    }

    /**
     * Asks the user what filtering operation they want to use
     * @param sc Scanner object to get user input
     * @return ListFilter chosen by the user
     */
    public static ListFilter askFilterOperation(Scanner sc) {
        final int EQUALS = 1;
        final int GREATER = 2;
        final int LESS = 3;
        final int GREATER_EQUALS = 4;
        final int LESS_EQUALS = 5;
        while (true) {
            System.out.println(EQUALS + " for equals");
            System.out.println(GREATER + " for greater");
            System.out.println(LESS + " for less");
            System.out.println(GREATER_EQUALS + " for greater equals");
            System.out.println(LESS_EQUALS + " for less equals");
            System.out.print(">>>> ");
            try {
                int input = Util.getInput(sc);
                if (input == EQUALS) return ListFilter.EQUALS;
                else if (input == GREATER) return ListFilter.GREATERTHAN;
                else if (input == LESS) return ListFilter.LESSTHAN;
                else if (input == GREATER_EQUALS) return ListFilter.GREATEREQUALS;
                else if (input == LESS_EQUALS) return ListFilter.LESSEQUALS;
                else throw new InputMismatchException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option !");
            }
        }
    }


    /**
     * Asks the user to choose a string to filter by
     * @param sc Scanner object to get user input
     * @return String chosen by the user
     */
    public static String askStringQuery(Scanner sc) {
        System.out.print("Enter String query: ");
        return sc.nextLine();
    }

    /**
     * Asks the user to choose a number to filter by
     * @param sc Scanner object to get user input
     * @return Int chosen by the user
     * @throws NumberFormatException if the number is invalid
     */
    public static int askIntQuery(Scanner sc) throws NumberFormatException {
        System.out.print("Enter number to query by: ");
        return Integer.parseInt(sc.nextLine());
    }
}
