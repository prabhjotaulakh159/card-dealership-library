package com.dealer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dealer.data.loaders.FileLoader;
import com.dealer.models.cars.Car;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
        FileLoader loader = new FileLoader();
        List<Car> cars = loader.getCars();
        System.out.println(cars.size());
    }
}
