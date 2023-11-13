package com.dealer;

import com.dealer.data.BulkDisplayer;
import com.dealer.data.DataDisplayer;
import com.dealer.data.FileReader;

public class App {
    public static void main(String[] args) {
        DataDisplayer displayer = new BulkDisplayer(new FileReader());
        displayer.displayCars();
        displayer.displayEmployees();
        displayer.displayCustomers();
    }
}
