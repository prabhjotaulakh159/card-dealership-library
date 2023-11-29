package com.dealer.display;

import com.dealer.business.EmployeeManager;
import com.dealer.data.Source;

public class EmployeeApp {
    public static void main(String[] args) {
        mainLoop(new EmployeeManager(Source.CSV));
    }

    private static void mainLoop(EmployeeManager app) {
        // final int 
        while (true) {
            printLimitedOptions();
            break;
        }
    }

    private static void printLimitedOptions() {
        for (Options option : Options.values()) {
            if (option == Options.VIEW_CUSTOMERS) break;
            System.out.println(option);
        }
    }
}
