package com.dealer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.dealer.data.BulkDisplayer;
import com.dealer.data.DataDisplayer;
import com.dealer.data.FileReader;

public class App {
    public static void main(String[] args) throws IOException {
        DataDisplayer displayer = new BulkDisplayer(new FileReader());
        displayer.displayCars();
        displayer.displayEmployees();
        displayer.displayCustomers();
    }
}
